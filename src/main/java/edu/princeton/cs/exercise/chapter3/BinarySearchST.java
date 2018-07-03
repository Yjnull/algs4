package edu.princeton.cs.exercise.chapter3;

/**
 * 基于有序数组的二分查找实现的 ST
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int n;

    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity)
    {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {return n;}

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public Value get(Key key)
    {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return values[i];
        else                                      return null;
    }

    public void put(Key key, Value value)
    {
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0)
        {
            values[i] = value;
            return;
        }

        for (int j = n; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    private int rank(Key key) {
        int lo = 0, hi = n - 1;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }

        return lo;
    }

}
