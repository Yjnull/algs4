package edu.princeton.cs.exercise.chapter1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Ex 1.2.6 &
 * Ex 1.2.7 &
 * Ex 1.2.15
 */
public class Ex1_2_6 {
    public static void main(String[] args) {
        String s = "ACTGACGf";
        String t = "TGACGfAC";
        boolean f = (s.length() == t.length()) && (s.concat(s).contains(t));
        StdOut.println(f);
        StdOut.println(mystery(s));
    }

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }

    //Ex 1.2.15 文件输入
    public static int[] readInts(String name) {
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ints[i] = Integer.parseInt(words[i]);
        }
        return ints;
    }
}
