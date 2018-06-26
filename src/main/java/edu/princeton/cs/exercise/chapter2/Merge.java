package edu.princeton.cs.exercise.chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.exercise.chapter1_4.Stopwatch;

public class Merge {

    private Merge(){}

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        for (int k =lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = a[j++];
            else if (j > hi)               a[k] = a[i++];
            else if (less(aux[j], aux[i])) a[k] = a[j++];
            else                           a[k] = a[i++];
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
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
