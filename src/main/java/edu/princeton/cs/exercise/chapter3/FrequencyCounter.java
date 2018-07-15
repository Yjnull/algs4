package edu.princeton.cs.exercise.chapter3;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {

    public static void main(String[] args) {
        int minLen = Integer.parseInt(args[0]);

        //ST<String, Integer> st = new ST<>();
        RedBlackBST<String, Integer> st = new RedBlackBST<>();
//        edu.princeton.cs.algs4.RedBlackBST<String, Integer> st = new edu.princeton.cs.algs4.RedBlackBST<>();
//        BST<String, Integer> st = new BST<>();

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minLen) continue;
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }

        String maxWord = " ";
        st.put(maxWord, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(maxWord))
                maxWord = word;

        StdOut.println(maxWord + " " + st.get(maxWord));
    }

}
