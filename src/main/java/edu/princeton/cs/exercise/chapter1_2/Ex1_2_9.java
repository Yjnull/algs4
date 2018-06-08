package edu.princeton.cs.exercise.chapter1_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Ex1_2_9 {
    public static int rank(int key, int[] a, Counter counter) {
        return rank(key, a, 0, a.length - 1, counter);
    }

    public static int rank(int key, int[] a, int lo, int hi, Counter counter) {
        if (lo > hi) {
            return -1;
        }
        counter.increment();
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1, counter);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi, counter);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int N = 1024;
        int[] a = new int[N];
        System.out.print("list: ");
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(N);
            StdOut.print(a[i] + ", ");
        }
        Arrays.sort(a);
        StdOut.println();
        System.out.print("Sorted list: ");
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
        int key = StdRandom.uniform(N);
        Counter counter = new Counter("keys");
        System.out.print("findPosition: ");
        System.out.println(rank(key, a, counter));
        System.out.println(counter);
    }
}
