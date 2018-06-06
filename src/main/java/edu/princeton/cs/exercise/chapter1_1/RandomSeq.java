package edu.princeton.cs.exercise.chapter1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class RandomSeq {
    public static void main(String[] args) {

        /*int N  = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(lo, hi);
            StdOut.printf("%.3f \n", x);
        }*/
        /*int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N*N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i < N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i*i);
            StdDraw.point(i, i*Math.log(i));
        }*/

        int n = 50;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform();
        }
        Arrays.sort(a);
        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 0; i < n; i++) {
            StdDraw.filledRectangle(1.0*i / n, a[i]/2.0, 0.5/n, a[i]/2.0);
        }
    }
}
