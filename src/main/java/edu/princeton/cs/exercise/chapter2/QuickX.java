package edu.princeton.cs.exercise.chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 *     QuickX : 30.0 , QuickXX : 25.3
 *     For 1000000 random Doubles
 *     QuickX is 0.8 times faster than QuickXX
 */
public class QuickX {

    private static final int INSERTION_SORT_CUTOFF = 13;

    public static void sort(Comparable[] a)
    {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;

        //切换到插入排序
        int n = hi - lo + 1;
        if ( n <= INSERTION_SORT_CUTOFF) {
            Insertion.sort(a, lo, hi + 1);
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi)
    {
        Comparable v = median3(a, lo, (lo+hi)/2, hi);
        int i = lo, j = hi - 1;

        while (true)
        {
            while (less(a[++i], v)) ;
            while (less(v, a[--j])) ;
            if (i < j) exch(a, i, j);
            else break;
        }
        exch(a, i, hi - 1);

        return i;
    }

    private static Comparable median3(Comparable[] a, int left, int center, int right)
    {
        if (less(a[center], a[left]))
            exch(a, left, center);
        if (less(a[right], a[left]))
            exch(a, left, right);
        if (less(a[right], a[center]))
            exch(a, center, right);
        exch(a, center, right - 1);
        return a[right - 1];
    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    /** 使用 静态泛型 消除警告 */
    private static <Key extends Comparable<Key>> boolean less2(Key v, Key w)
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

    public static void main(String[] args) {
        //String[] a = StdIn.readAllStrings();
        Integer[] a = new Integer[]{10,1,2,3,4,5,6,7,8,9};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
