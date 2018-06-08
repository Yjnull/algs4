package edu.princeton.cs.exercise.chapter1_2;

public class Accumulator {

    private int n;
    private double total;


    public void addDataValue(double val) {
        n++;
        total += val;
    }

    public double mean() {
        return total / n;
    }

    public String toString() {
        return "Mean (" + n + " values): " + String.format("%7.5f", mean());
    }
}
