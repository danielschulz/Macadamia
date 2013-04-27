package de.novensa.cs.performance.macadamia.management.jvm.resources.additionalInformation;

import de.novensa.cs.performance.macadamia.management.jvm.resources.enums.GenericResourceEnum;
import de.novensa.cs.performance.macadamia.management.jvm.util.TimeStampUtil;

import javax.annotation.Nullable;

/**
 * Saves additional information according to <code>GenericResourceEnum</code> and resource identifier.
 *
 * @author Daniel Schulz
 */
public class AdditionalResource<R, S, T> {

    private final GenericResourceEnum resourceEnum;
    private final R resourceIdentifier;
    private final S actionIdentifier;
    private final T runtimeInformation;
    private final long timeTaken;
    private final long timeStamp;


    // constructors
    public AdditionalResource(
            final GenericResourceEnum resourceEnum,
            final R resourceIdentifier,
            final S actionIdentifier,
            final long timeTaken) {

        this(resourceEnum, resourceIdentifier, actionIdentifier, null, timeTaken);
    }

    public AdditionalResource(
            final GenericResourceEnum resourceEnum,
            final R resourceIdentifier,
            final S actionIdentifier,
            @Nullable final T runtimeInformation,
            final long timeTaken) {

        assert null != resourceEnum;
        assert null != resourceIdentifier;
        assert null != actionIdentifier;

        this.timeStamp = TimeStampUtil.getTimeStamp();

        this.resourceEnum = resourceEnum;
        this.resourceIdentifier = resourceIdentifier;
        this.actionIdentifier = actionIdentifier;
        this.runtimeInformation = runtimeInformation;
        this.timeTaken = timeTaken;
    }


    // special getter
    public boolean hasRuntimeInformation() {
        return null != this.runtimeInformation;
    }


    // getter
    public GenericResourceEnum getResourceEnum() {
        return resourceEnum;
    }

    public R getResourceIdentifier() {
        return resourceIdentifier;
    }

    public S getActionIdentifier() {
        return actionIdentifier;
    }

    @Nullable
    public T getRuntimeInformation() {
        return runtimeInformation;
    }

    public long getTimeTaken() {
        return timeTaken;
    }
}
