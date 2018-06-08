package edu.princeton.cs.exercise.chapter1_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestVisualAccumulator {

    public static void main(String[] args) {
        int t = StdIn.readInt();
        //int t = Integer.parseInt(args[0]);
        VisualAccumulator a = new VisualAccumulator(t, 1.0);
        //SubAccumulator a = new SubAccumulator();
        for (int i = 0; i < t; i++) {
            a.addDataValue(StdRandom.uniform());
        }
        StdOut.println(a);

    }
}
