package edu.princeton.cs.exercise.chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.exercise.chapter1_4.Stopwatch;

public class MergeX {
    private static final int CUTOFF = 7;  // cutoff to insertion sort

    private MergeX(){}

    private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi)
    {

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              dst[k] = src[j++];
            else if (j > hi)               dst[k] = src[i++];
            else if (less(src[j], src[i])) dst[k] = src[j++];
            else                           dst[k] = src[i++];
        }
    }

    private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi)
    {
        // if (hi <= lo) return;
        if (hi <= lo + CUTOFF)
        {
            insertionSort(dst, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid + 1, hi);

        if (!less(src[mid+1], src[mid]))
        {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(src, dst, lo, mid, hi);
    }

    public static void sort(Comparable[] a)
    {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
    }

    private static void insertionSort(Comparable[] dst, int lo, int hi)
    {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(dst[j], dst[j - 1]); j--) {
                exch(dst, j, j - 1);
            }
        }
    }


    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean isSorted(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    private static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static double timeRandomInput(String alg, int N, int T)
    {
        double total = 0.0;
        Double[] a= new Double[N];
        for (int t = 0; t < T; t++)
        {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static double time(String alg, Double[] a)
    {
        Stopwatch timer = new Stopwatch();
        sort(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        //String[] a = StdIn.readAllStrings();
        double t = timeRandomInput("shell", 100000, 100);
        //assert isSorted(a);
        StdOut.printf("%s : %.1f  \n", "shell", t);
        //show(a);
    }
}
