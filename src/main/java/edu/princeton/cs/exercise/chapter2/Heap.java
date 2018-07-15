package edu.princeton.cs.exercise.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Heap {

    // This class should not be instantiated.
    private Heap() { }

    public static void sort(Comparable[] pq) {
        int n = pq.length;
        for (int i = n/2; i >= 1; i--)
            sink(pq, i, n);
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n)
        {
            int j = 2*k;
            if (j < n && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; heapsorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        //String[] a = StdIn.readAllStrings();
        Integer[] a = new Integer[]{19, 15,18,20,5,24,1,13,16,12,5};
        sort(a);
        show(a);
    }

}
