package de.novensa.cs.performance.macadamia.management.jvm.util.additionalInformation;

import java.util.List;
import java.util.Map;

/**
 * This class encapsulates additional information mapped by type.
 *
 * @author Daniel Schulz
 */
public class AdditionalResourceItem<R, S, T> {

    private Map<GenericResourceEnum, AdditionalResource<R, S, T>> additionalInformationMap;
    private List<AdditionalResource<R, S, T>> additionalResourceList;


}
