package edu.princeton.cs.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {

    public static void main(String[] args) {
        Stack<Double> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if ("(".equals(s) || ")".equals(s)) ;
            else if ("+".equals(s) ||
                     "-".equals(s) ||
                     "*".equals(s) ||
                     "/".equals(s) ||
                     "sqrt".equals(s))
            {
                double v = vals.pop();
                if      (s.equals("+")) v = vals.pop() + v;
                else if (s.equals("-")) v = vals.pop() - v;
                else if (s.equals("*")) v = vals.pop() * v;
                else if (s.equals("/")) v = vals.pop() / v;
                else if (s.equals("sqrt")) v = Math.sqrt(v);

                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));

        }

        StdOut.println(vals.pop());

    }

}
