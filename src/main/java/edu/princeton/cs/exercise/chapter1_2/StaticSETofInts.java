package edu.princeton.cs.exercise.chapter1_2;

import java.util.Arrays;

public class StaticSETofInts {

    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (a[mid] < key) lo = mid + 1;
            else if (a[mid] > key) hi = mid - 1;
            else                   return mid;
        }
        return -1;
    }
}
