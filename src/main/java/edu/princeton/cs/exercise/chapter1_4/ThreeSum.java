package edu.princeton.cs.exercise.chapter1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeSum {

    public static int count(int[] a)
    {
        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
       /* In in = new In(args[0]);
        int[] a = in.readAllInts();*/
       int N = 2000;
       int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + " triples " + time + " seconds" );
        //StdOut.println(count(a));
    }

}
