package edu.princeton.cs.exercise.chapter2;

import edu.princeton.cs.algs4.*;

public class TopM {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<>(m + 1);
        while (StdIn.hasNextLine())
        {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > m)
                pq.delMin();
        }

        Stack<Transaction> stack = new Stack<>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t : stack) {
            StdOut.println(t);
        }
    }

}
