package de.novensa.cs.performance.macadamia.management.jvm.resources;

import de.novensa.cs.performance.macadamia.management.jvm.resources.enums.GenericResourceEnum;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * This maps each <code>GenericResourceEnum</code> i to a value x_i in 0..1. The sum of all x_i there are is exactly one.
 * So all the values do sum up to one. The number of items is the number of enums in the mapping class. The amount of
 * enums is referenced to by n.
 * If uncertain the uniform distribution is taken where for each x_i the value is 1/n.
 *
 * @author Daniel Schulz
 */
public class JvmResourceCrucialDistribution {

    private final HashMap<GenericResourceEnum, Float> preciousMap =
            new HashMap<GenericResourceEnum, Float>(GenericResourceEnum.values().length);


    // constructor
    public JvmResourceCrucialDistribution() {
    }


    // special setter
    public void set(final Map<GenericResourceEnum, Float> map) {
        this.preciousMap.clear();

        for (GenericResourceEnum resourceEnum : map.keySet()) {
            this.preciousMap.put(resourceEnum, map.get(resourceEnum));
        }
    }

    public boolean hasItem(final GenericResourceEnum resourceEnum) {
        return null != this.preciousMap.get(resourceEnum);
    }


    // getter and setter
    public boolean set(final GenericResourceEnum resourceEnum, final Float value) {
        return null != this.preciousMap.put(resourceEnum, value);
    }

    @Nullable
    public Float get(final GenericResourceEnum resourceEnum) {
        return this.preciousMap.get(resourceEnum);
    }
}
