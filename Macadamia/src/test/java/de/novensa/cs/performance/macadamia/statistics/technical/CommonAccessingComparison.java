package de.novensa.cs.performance.macadamia.statistics.technical;

import de.novensa.cs.performance.macadamia.management.jvm.util.TimeStampUtil;
import de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles.Quantiles;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Tests the Macadamia performance against common implementation patterns.
 *
 * @author Daniel Schulz
 */
public class CommonAccessingComparison extends MasterSortTestCase {

    // constants
    private static final long SEED = 4096*4096;
    private static final Random RANDOM = new Random(SEED);
    private static final long FACTOR = 4096;

    // member fields
    private static int valueCount = 4096;
    private static List<Integer> randomNumbers = new ArrayList<Integer>(valueCount);


    public void testCommonVsRadixTestCaseTime() throws Exception {

        List<Integer> commons = getRandomValueList(valueCount);
        List<Integer> radixs = new ArrayList<Integer>(commons);

        getTimeForCommonAccessing(commons, null);
        getTimeForRadixAccessing(radixs,  null);
    }

    // technical logic
    public static List<Integer> getRandomValueList(final int valueCount) {

        List<Integer> result = new ArrayList<Integer>(valueCount);

        int i = 0;
        while (i++ < valueCount) {
            result.add((int) (Math.abs(RANDOM.nextGaussian())*FACTOR));
        }

        return result;
    }


    public static long getTimeForCommonAccessing(final List<Integer> values, final Pair<Integer, Integer> minMax) {

        List<Integer> rawValues = new ArrayList<Integer>();
        for (Integer i : values) {
            rawValues.add(i);
        }

        System.gc();
        final long start = TimeStampUtil.getTimeStamp();
        List<Integer> result = getValuesBetween(rawValues, minMax);
        final long end = TimeStampUtil.getTimeStamp();

        assert valuesAreTheSameButOutOfOrder(values, result);
        assert !equalContentsInBothLists(values, result);

        return end - start;
    }

    public static long getTimeForRadixAccessing(final List<Integer> values, final Pair<Integer, Integer> minMax) {

        final int max = Quantiles.getMinAverageMaxValue(values).getValue2();
        System.gc();
        final long start = TimeStampUtil.getTimeStamp();
        List<Integer> result = RadixSort.sort(values, max);
        final long end = TimeStampUtil.getTimeStamp();

        assert valuesAreTheSameButOutOfOrder(values, result);
        assert !equalContentsInBothLists(values, result);

        return end - start;
    }

    private static List<Integer> getValuesBetween(List<Integer> values, Pair<Integer, Integer> minMax) {
        Collections.sort(values);

        /*
        int min = minMax.getValue0();
        int max = minMax.getValue1();

        List<Integer> rangeItems = new ArrayList<Integer>();
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) < max && min < values.get(i)) {
                rangeItems.add(values.get(i));
            }
        }
        */

        return values;
    }
}
