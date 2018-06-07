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

    private static void ex1_1_5() {
        StdOut.println("--- ex1.1.5 ---------------------------------------------------------------------------------");
        double x = StdIn.readDouble();
        double y = StdIn.readDouble();
        System.out.println(x > 0 && x < 1 && y > 0 && y < 1);
    }

    private static void ex1_1_6() {
        StdOut.println("--- ex1.1.6 斐波拉契 ---------------------------------------------------------------------------------");
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    private static void ex1_1_7() {
        StdOut.println("--- ex1.1.7 a 平方根 ---------------------------------------------------------------------------------");
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.printf("9的平方根保留5位小数 : %.5f\n", t);

        StdOut.println("--- ex1.1.7 b ---------------------------------------------------------------------------------");
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);

        StdOut.println("--- ex1.1.7 c ---------------------------------------------------------------------------------");
        int sum2 = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum2++;
            }
        }
        StdOut.println(sum2);
    }

    private static void ex1_1_8() {
        StdOut.println("--- ex1.1.8 ---------------------------------------------------------------------------------");
        StdOut.println('b');
        StdOut.println('b' + 'c');
        StdOut.println((char) ('a' + 4));
    }

    private static void ex1_1_9(int N) {
        StdOut.println("--- ex1.1.9 ---------------------------------------------------------------------------------");
        StdOut.println("Java内置方法输出: " + Integer.toBinaryString(N));

        String s = "";
        for (int i = N; i > 0; i/=2) {
            s = (i%2) + s;
        }
        StdOut.println("题解输出: " + s);
    }

    public static void main(String[] args) {
        ex1_1_1();
        ex1_1_2();
        ex1_1_6();
        ex1_1_7();
        ex1_1_8();
        ex1_1_9(66);
    }
}
