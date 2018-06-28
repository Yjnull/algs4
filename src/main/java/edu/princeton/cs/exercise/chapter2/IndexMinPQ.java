package edu.princeton.cs.exercise.chapter2;

import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> {

    private int[] pq;
    private int[] qp;
    private Key[] keys;
    private int n;

    public IndexMinPQ(int maxN)
    {
        if (maxN < 0) throw new IllegalArgumentException();
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public int size()
    {
        return n;
    }

    public boolean contains(int k)
    {
        return qp[k] != -1;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];
    }

    public void insert(int k, Key key)
    {
        if (contains(k)) throw new RuntimeException("item is already in pq");
        n++;
        qp[k] = n;
        pq[n] = k;
        keys[k] = key;
        swim(n);
    }

    public int delMin()
    {
        if (n == 0) throw new RuntimeException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        qp[min] = -1;            // delete
        keys[pq[n+1]] = null;    // to help with garbage collection
        pq[n+1] = -1;            // not needed
        return min;
    }

    /***************************************************************************
     * Helper functions
     ***************************************************************************/
    private boolean greater(int i, int j)
    {
        return keys[i].compareTo(keys[j]) > 0;
    }

    private void exch(int i, int j)
    {
        Key t = keys[i];
        keys[i] = keys[j];
        keys[j] = t;
    }

    private void swim(int k)
    {
        while (k > 1 && greater(k/2, k))
        {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k)
    {
        while (2*k <= n)
        {
            int j = 2*k;
            //找到子节点中的较大者
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

}
