package edu.princeton.cs.exercise.chapter1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;

public class Wget {

    /**
     *
     * @param args  https://introcs.cs.princeton.edu/java/data/codes.csv
     */
    public static void main(String[] args) {
        String url = args[0];
        In in = new In(url);
        String data = in.readAll();

        StdOut.println(data);

        String filename = url.substring(url.lastIndexOf('/') + 1);
        Out out = new Out(filename);
        out.println(data);
        out.close();
    }

}
