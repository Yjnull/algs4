package edu.princeton.cs.exercise.chapter1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 随机连接
 */
public class Ex_1_1_31 {
    /**
     *
     * @param N 在圆上画出大小为0.015 且间距相等的 N 个点
     * @param p 将每对点按概率 p 用灰线连接
     */
    public static void drawRandConn(int N, double p)
    {
        StdDraw.setCanvasSize(1024, 1024);
        StdDraw.setScale(-1.0, 1.0);
        StdDraw.setPenRadius(.015);

        double[][] d = new double[N][2];
        for (int i = 0; i < N; i++)
        {
            d[i][0] = Math.cos(2 * Math.PI * i / N);
            d[i][1] = Math.sin(2 * Math.PI * i / N);
            StdDraw.point(d[i][0], d[i][1]);
        }

        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.GRAY);

        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                if (StdRandom.bernoulli(p))
                    StdDraw.line(d[i][0], d[i][1], d[j][0], d[j][1]);
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        p = Math.max(0, Math.min(1, p));

        drawRandConn(N, p);
    }

}
