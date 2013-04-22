package de.novensa.cs.performance.macadamia.management.jvm.util;

import javax.annotation.Nullable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class finds out what resource is to what extend precious and therefore provides hints if the implementation
 * can reach the target in a different approach. An example may be using <code>Radix-Sort</code> when CPU time is
 * crucial and <code>Collections.sort</code> or <code>Arrays.sort</code> (both merge sort) when memory is crucial to
 * a higher extend.
 *
 * @author Daniel Schulz
 */
public abstract class AbstractCrucialJvmResources implements Runnable {

    // constants
    @SuppressWarnings("FieldCanBeLocal")
    private final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;


    // field members
    protected final long timeStamp;
    protected final JvmResourceDetailsContainer jvmResourceDetailsContainer;
    protected final long initDelay;
    protected final long period;
    protected final TimeUnit timeUnit;

    protected long updateCount = 0L;
    protected final String reflectiveReference;


    // technical logic
    public abstract void scheduleUpdates();


    // runnable implementations
    @Override
    public void run() {
        ++this.updateCount;
        scheduleUpdates();
    }


    // constructor
    public AbstractCrucialJvmResources(final long initDelay,
                                       final long period) {

        this(initDelay, period, null, null);
    }

    public AbstractCrucialJvmResources(final long initDelay,
                                       final long period,
                                       @Nullable final TimeUnit timeUnit) {

        this(initDelay, period, timeUnit, null);
    }

    public AbstractCrucialJvmResources(final long initDelay,
                                       final long period,
                                       @Nullable final TimeUnit timeUnit,
                                       @Nullable final String reflectiveReference) {

        // get immutable fields
        this.timeStamp = System.nanoTime();
        this.jvmResourceDetailsContainer = JvmResourceDetailsContainer.getInstance();

        // set field members
        this.initDelay = initDelay;
        this.period = period;
        this.timeUnit = ((null != timeUnit) ? timeUnit : DEFAULT_TIME_UNIT);
        this.reflectiveReference = null != reflectiveReference ? reflectiveReference : this.toString();

        // set up runnable
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this, initDelay, period, this.timeUnit);
    }


    // special getter
    public JvmResourceDetails get(final int index) {
        return this.jvmResourceDetailsContainer.get(index);
    }

    public int getHistorySize() {
        return this.jvmResourceDetailsContainer.getHistorySize();
    }


    // getter
    public long getTimeStamp() {
        return timeStamp;
    }
}
