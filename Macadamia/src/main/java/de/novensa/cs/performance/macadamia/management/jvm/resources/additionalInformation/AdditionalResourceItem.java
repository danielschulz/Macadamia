package de.novensa.cs.performance.macadamia.management.jvm.resources.additionalInformation;

import de.novensa.cs.performance.macadamia.management.jvm.resources.enums.GenericResourceEnum;
import de.novensa.cs.performance.macadamia.management.jvm.util.TimeStampUtil;

import java.util.List;
import java.util.Map;

/**
 * This class encapsulates additional information mapped by type.
 *
 * @author Daniel Schulz
 */
public class AdditionalResourceItem<R, S, T> {

    // caching fields
    private Map<GenericResourceEnum, List<AdditionalResource<R, S, T>>> resourceByEnumTypeMap;
    private Map<R, List<AdditionalResource<R, S, T>>> resourceByResourceMap;
    private Map<S, List<AdditionalResource<R, S, T>>> resourceByActionMap;
    private List<AdditionalResource<R, S, T>> resourceList;
    private final long timeStamp;


    // constructor
    public AdditionalResourceItem() {
        this.timeStamp = TimeStampUtil.getTimeStamp();
    }


}
