package de.novensa.cs.performance.macadamia.management.jvm.resources;

import de.novensa.cs.performance.macadamia.util.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * This list is a Ring buffer. Unlike the Apache Common´s Collections <code>CircularFifoBuffer</code>
 * this instance can access all times.
 *
 * @author Daniel Schulz
 */
public class JvmResourceDetailsHistoryContainerList<T> extends ArrayList<T> {

    // member fields
    private final int circularBufferSize;   // max size of the list
    //    private int curIndexPos = 0;            // next write operation will happen to this index


    // constructors
    public JvmResourceDetailsHistoryContainerList() {
        this(new ArrayList<T>(Constants.INITIAL_SIZE_OF_MANAGEMENT_HISTORY_LIST), -1);
    }

    public JvmResourceDetailsHistoryContainerList(final int circularBufferSize) {
        this(new ArrayList<T>(circularBufferSize), circularBufferSize);
    }

    public JvmResourceDetailsHistoryContainerList(Collection<? extends T> c) {
        this(c, -1);
        //this.curIndexPos = c.size();
    }

    public JvmResourceDetailsHistoryContainerList(Collection<? extends T> c, final int circularBufferSize) {
        super(circularBufferSize);
        this.circularBufferSize = 0 < circularBufferSize ? circularBufferSize : -1;

        if (c.size() <= circularBufferSize) {
            // max size fits available item count
            super.addAll(c);
        } else {
            // max size does not fit available item count
            this.addAll(c);
        }
    }


    // super overwrites
    @Override
    public void add(int index, T element) {
        if (index - 1 >= this.circularBufferSize) {
            // one item has to be dropped anyway
            super.remove(0);
        }

        // the element fits within without resizing
        super.add(index, element);
    }

    @Override
    public boolean add(T t) {
        if (this.circularBufferSize <= super.size()) {
            // if the new item does not fit within the list --> remove first in list
            super.remove(0);
        }

        return super.add(t);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == this.circularBufferSize) {
            // c fits perfectly in the space
            super.clear();
            return super.addAll(c);

        } else if (c.size() < this.circularBufferSize) {
            // c does append the items from c and drops the most left items in this list

            // overwrite items
            super.removeRange(0, c.size());
            super.addAll(c);

        } else {
            // c is way bigger than it can fit in here -- so the most right items still fitting are taken

            super.clear();

            Object[] incomingItems = c.toArray();
            T[] resultingItems = (T[]) new Object[this.circularBufferSize];
            int startingIndex = incomingItems.length - this.circularBufferSize;
            System.arraycopy(incomingItems, startingIndex, resultingItems, 0, this.circularBufferSize);

            super.addAll(Arrays.asList(resultingItems));
        }






        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return super.addAll(index, c);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public T remove(int index) {
        return super.remove(index);
    }


    // getter
    public int getCircularBufferSize() {
        return circularBufferSize;
    }
}
