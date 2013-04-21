package de.novensa.cs.performance.macadamia.management.jvm;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * This maps each <code>JvmResourceEnum</code> i to a value x_i in 0..1. The sum of all x_i there are is exactly one.
 * So all the values do sum up to one. The number of items is the number of enums in the mapping class. The amount of
 * enums is referenced to by n.
 * If uncertain the uniform distribution is taken where for each x_i the value is 1/n.
 *
 * @author Daniel Schulz
 */
public class JvmResourceCrucialDistribution {

    private final HashMap<JvmResourceEnum, Float> preciousMap =
            new HashMap<JvmResourceEnum, Float>(JvmResourceEnum.values().length);


    // constructor
    public JvmResourceCrucialDistribution() {
    }


    // special setter
    public void set(final Map<JvmResourceEnum, Float> map) {
        this.preciousMap.clear();

        for (JvmResourceEnum resourceEnum : map.keySet()) {
            this.preciousMap.put(resourceEnum, map.get(resourceEnum));
        }
    }

    public boolean hasItem(final JvmResourceEnum resourceEnum) {
        return null != this.preciousMap.get(resourceEnum);
    }


    // getter and setter
    public boolean set(final JvmResourceEnum resourceEnum, final Float value) {
        return null != this.preciousMap.put(resourceEnum, value);
    }

    @Nullable
    public Float get(final JvmResourceEnum resourceEnum) {
        return this.preciousMap.get(resourceEnum);
    }
}
