package de.novensa.cs.performance.macadamia.statistics.technical;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Radix sort for Java. Derived from: www.github.com/EroMod/RadixSort
 * https://github.com/EroMod/RadixSort/blob/master/RadixSort/src/radixsort/TheControl.java
 *
 * @author EroMod, Daniel Schulz
 */
public class RadixSort {

    private final static int DECIMAL_MAPPING_COUNT = 10;

    public static <V extends Integer /*Number*/> List<Integer> sortRadix(List<Integer> numbers) {
        ArrayList<Integer> localNumbers = new ArrayList<Integer>();

        Integer maxValue = -99999999;
        for (Integer nr : numbers){
            localNumbers.add(nr);
            if (nr > maxValue){
                maxValue = nr;
            }
        }

        ArrayList<ArrayList<Integer>> bin = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i < DECIMAL_MAPPING_COUNT; i++){
            ArrayList<Integer> myList = new ArrayList<Integer>();
            bin.add(myList);
        }

        Integer pwr10 = 1;
        while (pwr10 < maxValue){
            Iterator myIter = localNumbers.iterator();
            while (myIter.hasNext()){
                Integer nr = (Integer)myIter.next();
                if (nr < pwr10)
                {
                    bin.get(0).add(nr);
                }
                else
                {
                    Integer help = nr / pwr10;
                    Integer pos = help % DECIMAL_MAPPING_COUNT;
                    bin.get(pos).add(nr);
                }
            }

            localNumbers.clear();
            for (int i = 0; i < DECIMAL_MAPPING_COUNT; i++){
                ArrayList<Integer> myList = bin.get(i);
                for (int j = 0; j < myList.size(); j++){
                    localNumbers.add(myList.get(j));
                }
                bin.get(i).clear();
            }

            pwr10 = DECIMAL_MAPPING_COUNT * pwr10;
        }


        numbers.clear();
        for (Integer nr : localNumbers){
            numbers.add(nr);
        }

        return numbers;
    }
}
