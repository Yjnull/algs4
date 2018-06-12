package edu.princeton.cs.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]),
                m = Integer.parseInt(args[1]);

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }

        int k = 0;
        while (!queue.isEmpty())
        {
            int x = queue.dequeue();

            if (++k % m == 0)
                StdOut.print(x + " ");
            else
                queue.enqueue(x);
        }
    }
}
