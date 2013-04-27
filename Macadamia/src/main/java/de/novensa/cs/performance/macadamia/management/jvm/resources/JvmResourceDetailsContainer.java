package de.novensa.cs.performance.macadamia.management.jvm.resources;

import de.novensa.cs.performance.macadamia.management.jvm.resources.enums.ApplicationPhase;
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
    private final Map<String, List<JvmResourceDetails>> reflectiveReferenceResourceDetailsMap;
    private final Map<ApplicationPhase, List<JvmResourceDetails>> applicationPhasesResourceDetailsMap;
    private static JvmResourceDetailsContainer container = null;


    // constructors for singleton
    private JvmResourceDetailsContainer() {
        this.details = new ArrayList<JvmResourceDetails>(Constants.INITIAL_SIZE_OF_MANAGEMENT_HISTORY_LIST);

        this.reflectiveReferenceResourceDetailsMap = new TreeMap<String, List<JvmResourceDetails>>(
                new ReflectiveReferenceToResourceDetailsComparator<String>());
        this.applicationPhasesResourceDetailsMap = new TreeMap<ApplicationPhase, List<JvmResourceDetails>>(
                new ReflectiveReferenceToResourceDetailsComparator<ApplicationPhase>());
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


    public int getHistorySizeAll() {
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


    public List<JvmResourceDetails> getAllJvmResourceDetails() {
        return this.details;
    }


    @Nullable
    public List<JvmResourceDetails> getJvmResourceDetailsForCollector(final String collectorId) {
        if (null != collectorId) {
            this.reflectiveReferenceResourceDetailsMap.get(collectorId);
        }

        return null;
    }


    @Nullable
    public List<JvmResourceDetails> getJvmResourceDetailsForCollector(final ApplicationPhase applicationPhase) {
        if (null != applicationPhase) {
            this.applicationPhasesResourceDetailsMap.get(applicationPhase);
        }

        return null;
    }


    protected boolean add(
            final JvmResourceDetails resourceDetails,
            final String reflectiveReference,
            final ApplicationPhase applicationPhase) {

        // reflective reference mapping
        List<JvmResourceDetails> itemFromReflectiveReferenceMap =
                this.reflectiveReferenceResourceDetailsMap.get(reflectiveReference);

        if (null == itemFromReflectiveReferenceMap) {
            itemFromReflectiveReferenceMap =
                    new ArrayList<JvmResourceDetails>(Constants.INITIAL_SIZE_OF_MANAGEMENT_HISTORY_LIST);
        }

        itemFromReflectiveReferenceMap.add(resourceDetails);
        this.reflectiveReferenceResourceDetailsMap.put(reflectiveReference, itemFromReflectiveReferenceMap);


        // application phase mapping
        List<JvmResourceDetails> itemFromApplicationPhasesMap =
                this.applicationPhasesResourceDetailsMap.get(applicationPhase);

        if (null == itemFromApplicationPhasesMap) {
            itemFromApplicationPhasesMap =
                    new ArrayList<JvmResourceDetails>(Constants.INITIAL_SIZE_OF_MANAGEMENT_HISTORY_LIST);
        }

        itemFromApplicationPhasesMap.add(resourceDetails);
        this.applicationPhasesResourceDetailsMap.put(applicationPhase, itemFromApplicationPhasesMap);


        // simple listing
        return this.details.add(resourceDetails);
    }
}
