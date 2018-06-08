package edu.princeton.cs.exercise.chapter1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.Arrays;

public class Ex1_2_1 {
    public static void main(String[] args) {
        /*int N = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[N];
        StdDraw.setPenRadius(.005);
        for (int i = 0; i < N; i++) {
            points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            points[i].draw();
        }

        if (N > 1) {
            double min = points[0].distanceTo(points[1]);
            StdOut.println("Min distance " + min);
        }*/

        int x0 = Integer.parseInt(args[0]);
        int y0 = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();

        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            int x = StdRandom.uniform(100);
            int y = StdRandom.uniform(100);
            points[i] = new Point2D(x, y);
            points[i].draw();
        }

        // draw p = (x0, x1) in red
        Point2D p = new Point2D(x0, y0);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.005);
        p.draw();


        // draw line segments from p to each point, one at a time, in polar order
        Color[] colors = {StdDraw.GREEN, StdDraw.BLUE, StdDraw.RED};
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.RED);
        Arrays.sort(points, p.polarOrder());
        for (int i = 0; i < n - 1; i++) {
            StdDraw.setPenColor(colors[StdRandom.uniform(3)]);
            for (int j = i + 1; j < n; j++) {
                points[i].drawTo(points[j]);
                StdDraw.show();
                //StdDraw.pause(100);
            }
        }

    }
}
