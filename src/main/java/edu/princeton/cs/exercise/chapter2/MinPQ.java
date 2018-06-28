package edu.princeton.cs.exercise.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class MinPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n;

    public MinPQ(int initCapacity)
    {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    public MinPQ()
    {
        this(1);
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public int size()
    {
        return n;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    private void resize(int capacity) {
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key v)
    {
        if (n == pq.length - 1) resize(2 * pq.length);

        pq[++n] = v;
        swim(n);
    }

    public Key delMin()
    {
        Key max = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);

        if ((n > 0) && (n == (pq.length-1) / 4)) resize(pq.length / 2);

        return max;
    }

    /***************************************************************************
     * Helper functions
     ***************************************************************************/
    private boolean greater(int i, int j)
    {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j)
    {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
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


    public static void main(String[] args) {
        edu.princeton.cs.algs4.MinPQ<String> pq = new edu.princeton.cs.algs4.MinPQ<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) StdOut.print(pq.delMin() + " ");
        }
        StdOut.println("(" + pq.size() + " left on pq)");
    }
}
