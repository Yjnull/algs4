package edu.princeton.cs.exercise.chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex01_39 {

    private static void ex1_1_1() {
        StdOut.println("--- ex1.1.1 ---------------------------------------------------------------------------------");
        StdOut.println( (0 + 15) / 2 );
        StdOut.println( 2.0e-6 * 100000000.1 );
        StdOut.println( true && false || true && true );
    }

    private static void ex1_1_2() {
        StdOut.println("--- ex1.1.2 ---------------------------------------------------------------------------------");
        StdOut.println((1 + 2.236) / 2);
        StdOut.println(1 + 2 + 3 + 4.0);
        StdOut.println(4.1 >= 4);
        StdOut.println(1 + 2 + "3");
    }

    private static void ex1_1_3() {
        StdOut.println("--- ex1.1.3 ---------------------------------------------------------------------------------");
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();
        if (a == b && b == c)
            StdOut.println("equal");
        else StdOut.println("not equal");
    }

    public static void main(String[] args) {
        ex1_1_1();
        ex1_1_2();
        ex1_1_3();
    }
}
