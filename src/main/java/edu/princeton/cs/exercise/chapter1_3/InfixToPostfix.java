package edu.princeton.cs.exercise.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "(": break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    ops.push(s);
                    break;
                case ")":
                    String op = ops.pop();
                    String v= vals.pop();
                    if (op.equals("+") ||
                            op.equals("-") ||
                            op.equals("*") ||
                            op.equals("/"))
                        v = String.format("%s %s %s", vals.pop() , v, op);
                    else if (op.equals("sqrt"))
                        v = String.format("%s %s ", v , op);

                    vals.push(v);
                    break;
                default:
                    vals.push(s);
                    break;
            }
        }
        StdOut.println(vals.pop());
    }
}
