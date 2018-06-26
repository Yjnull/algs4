package edu.princeton.cs.exercise.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InsertionX {

    public static void sort(Comparable[] a)
    {
        int N = a.length;

        // 把最小的元素放置在数组的最左边，充当哨兵
        int exchanges = 0;
        for (int i = N - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                exch(a, i, i-1);
                exchanges++;
            }
        }

        if (exchanges == 0) return;

        for (int i = 2; i < N; i++) {
            Comparable temp = a[i];
            int j = i;
            while (less(temp, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
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
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
