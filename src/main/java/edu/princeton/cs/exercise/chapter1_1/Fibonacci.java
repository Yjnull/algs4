package edu.princeton.cs.exercise.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

public class Fibonacci
{
    /**
     * 效率极低 100 个数要等很久
     * @param N
     * @return
     */
    public static long F(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }

    public static long Fib(int N)
    {
        long[] f = new long[N+1];
        return Fib(N, f);
    }

    public static long Fib(int N, long[] f)
    {
        if (f[N] == 0)
        {
            if (N == 1)
                f[N] = 1;
            else if (N > 1)
                f[N] = Fib(N-1, f) + Fib(N-2, f);
        }

        return f[N];
    }

    public static long Fib2(int N) {
        long f = 0;
        long g = 1;
        for (int i = 0; i < N; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            StdOut.println(i + " " + Fib2(i));
        }
    }
}
