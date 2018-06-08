package edu.princeton.cs.exercise.chapter1_2;

import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Field;

public class MutableInteger {
    public static void main(String[] args) {
        Integer x = 17;
        StdOut.println(x);
        mutate(x);
        StdOut.println(x);
    }

    // change the Integer to 9999999
    public static void mutate(Integer x) {
        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.setInt(x, 3333);
        }
        catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
