package edu.princeton.cs.exercise.chapter1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BruteForceSearch {

    private static int rank2(int key, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        long s = System.currentTimeMillis();
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank2(key, whitelist) < 0)
                StdOut.println(key);
        }

        long end = System.currentTimeMillis();
        StdOut.println("BruteForceSearch time : " + (end - s));
    }
}
