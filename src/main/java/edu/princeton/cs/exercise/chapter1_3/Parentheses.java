package edu.princeton.cs.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

    public static boolean isBalanced(String s) {
        Stack<Character> parent = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                parent.push(c);
            else if ( (c == ')' && (parent.isEmpty() || parent.pop() != '(')) ||
                    (c == ']' && (parent.isEmpty() || parent.pop() != '[')) ||
                    (c == '}' && (parent.isEmpty() || parent.pop() != '{')))
                return false;
        }

        return parent.isEmpty();
    }

    public static void main(String[] args) {

        String s = StdIn.readAll().trim();
        StdOut.println(isBalanced(s));
    }
}
