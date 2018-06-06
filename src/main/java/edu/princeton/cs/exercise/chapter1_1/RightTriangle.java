package edu.princeton.cs.exercise.chapter1_1;

import edu.princeton.cs.algs4.StdDraw;

public class RightTriangle {
    public static void main(String[] args) {
        StdDraw.square(.5,.5,.5);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(.5,.5,.9,.5);
        StdDraw.line(.9,.5,.9,.8);
        StdDraw.line(.5,.8,.5,.5);
        StdDraw.circle(.7, .65, .25);
    }
}
