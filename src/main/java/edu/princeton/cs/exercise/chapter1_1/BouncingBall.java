package edu.princeton.cs.exercise.chapter1_1;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * 弹跳球
 */
public class BouncingBall {

    public static void main(String[] args) {
        //设置画布大小  画笔半径  坐标系刻度
        /*double pivot = Math.PI * 2;
        StdDraw.setScale(-pivot, pivot);
        StdDraw.enableDoubleBuffering();

        int N = 200;

        double rx = 0.00, ry = 0.00;
        double vx = 0.01, vy = 0.01;
        double radius = 0.05;

        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.filledSquare(0, 0, pivot);

        for (int i = 0; i < N; i++) {
            rx = Math.PI * i / N;
            ry = Math.sin(Math.PI * i / N);


            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(rx, ry, radius);

            StdDraw.show();
            StdDraw.pause(10);
        }

        for (double i = rx; i >= -(pivot/2) ; i -= 0.023) {
            rx = i;
            if (i < 0) ry += 0.023;
            else ry -= 0.023;

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(rx, ry, radius);

            StdDraw.show();
            StdDraw.pause(10);
        }

        for (int i = 0; i < N; i++) {
            rx = (Math.PI * i / N) - (pivot/2);
            ry = Math.sin(Math.PI * i / N);

            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(rx, ry, radius);

            StdDraw.show();
            StdDraw.pause(10);
        }*/


        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // initial values
        double rx = 0.480, ry = 0.860;     // position
        double vx = 0.015, vy = 0.023;     // velocity
        double radius = 0.05;              // radius

        // main animation loop
        while (true)  {

            // bounce off wall according to law of elastic collision
            if (Math.abs(rx + vx) > 1.0 - radius) vx = -vx;
            if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;

            // update position
            rx = rx + vx;
            ry = ry + vy;

            // clear the background
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(0, 0, 1.0);

            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);

            // display and pause for 20 ms
            StdDraw.show();
            StdDraw.pause(20);
        }
    }

}
