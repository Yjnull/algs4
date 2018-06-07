package edu.princeton.cs.exercise.chapter1_1;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class BouncingBall {

    public static void main(String[] args) {
        //设置画布大小  画笔半径  坐标系刻度
        double pivot = Math.PI * 2;
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
        }
    }

}
