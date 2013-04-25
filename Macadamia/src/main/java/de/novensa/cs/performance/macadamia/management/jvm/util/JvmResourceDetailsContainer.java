package de.novensa.cs.performance.macadamia.management.jvm.util;

import de.novensa.cs.performance.macadamia.util.Constants;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Collect all <code>JvmResourceDetails</code> for history analysis.
 *
 * @author Daniel Schulz
 */
public class JvmResourceDetailsContainer {

    private final List<JvmResourceDetails> details;
    private final Map<String, List<JvmResourceDetails>> resourceDetailsMap;
    private static JvmResourceDetailsContainer container = null;

    // constructors for singleton
    private JvmResourceDetailsContainer() {
        this.details = new ArrayList<JvmResourceDetails>(Constants.INITIAL_SIZE_OF_MANAGEMENT_HISTORY_LIST);
        this.resourceDetailsMap = new TreeMap<String, List<JvmResourceDetails>>(
                new ReflectiveReferenceToResourceDetailsComparator<String>());
    }


    public static synchronized JvmResourceDetailsContainer getInstance() {
        if (null == container) {
            container = new JvmResourceDetailsContainer();
        }

        return container;
    }


    // special getter and setter
    public boolean hasHistoryItem(final JvmResourceDetails resourceDetails) {
        return this.details.contains(resourceDetails);
    }

    @Nullable
    public boolean hasHistoryItemIn(final int index) {
        return this.details.size() > index && 0 <= index && null != this.details.get(index);
    }

    public int getHistorySize() {
        return this.details.size();
    }

    @Nullable
    public JvmResourceDetails get(final int index) {
        if (this.details.size() > index && 0 <= index) {
            return this.details.get(index);
        }

        // error case only
        return null;
    }

    protected boolean add(final JvmResourceDetails resourceDetails, final String reflectiveReference) {
        List<JvmResourceDetails> itemFromMap = this.resourceDetailsMap.get(reflectiveReference);

        if (null == itemFromMap) {
            itemFromMap = new ArrayList<JvmResourceDetails>(Constants.INITIAL_SIZE_OF_MANAGEMENT_HISTORY_LIST);
        }

        itemFromMap.add(resourceDetails);
        this.resourceDetailsMap.put(reflectiveReference, itemFromMap);

        return this.details.add(resourceDetails);
    }
}
