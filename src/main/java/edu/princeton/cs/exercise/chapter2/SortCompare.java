package edu.princeton.cs.exercise.chapter2;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.exercise.chapter1_4.Stopwatch;

import java.util.Arrays;

public class SortCompare {

    public static double time(String alg, Double[] a)
    {
        Stopwatch timer = new Stopwatch();
        if      (alg.equals("Insertion"))       Insertion.sort(a);
        else if (alg.equals("InsertionX"))      InsertionX.sort(a);
//        else if (alg.equals("BinaryInsertion")) BinaryInsertion.sort(a);
        else if (alg.equals("Selection"))       Selection.sort(a);
        else if (alg.equals("Shell"))           Shell.sort2(a);
        else if (alg.equals("Merge"))           Merge.sort(a);
        else if (alg.equals("MergeX"))          MergeX.sort(a);
        else if (alg.equals("MergeBU"))         MergeBU.sort(a);
        else if (alg.equals("Quick"))           Quick.sort(a);
        else if (alg.equals("Quick3way"))       Quick3way.sort(a);
        else if (alg.equals("QuickX"))          QuickX.sort(a);
        else if (alg.equals("QuickXX"))         QuickXX.sort(a);
        else if (alg.equals("Heap"))            Heap.sort(a);
        else if (alg.equals("System"))          Arrays.sort(a);
        else throw new IllegalArgumentException("Invalid algorithm" + alg);

        return timer.elapsedTime();
    }

    public static double time2(String alg, Double[] a)
    {
        Stopwatch timer = new Stopwatch();
        if      (alg.equals("Insertion"))       edu.princeton.cs.algs4.Insertion.sort(a);
        else if (alg.equals("InsertionX"))      edu.princeton.cs.algs4.InsertionX.sort(a);
        else if (alg.equals("BinaryInsertion")) edu.princeton.cs.algs4.BinaryInsertion.sort(a);
        else if (alg.equals("Selection"))       edu.princeton.cs.algs4.Selection.sort(a);
        else if (alg.equals("Shell"))           edu.princeton.cs.algs4.Shell.sort(a);
        else if (alg.equals("Merge"))           edu.princeton.cs.algs4.Merge.sort(a);
        else if (alg.equals("MergeX"))          edu.princeton.cs.algs4.MergeX.sort(a);
        else if (alg.equals("MergeBU"))         edu.princeton.cs.algs4.MergeBU.sort(a);
//        else if (alg.equals("Quick"))           Quick.sort(a);
//        else if (alg.equals("Quick3way"))       Quick3way.sort(a);
//        else if (alg.equals("QuickX"))          QuickX.sort(a);
        else if (alg.equals("Heap"))            edu.princeton.cs.algs4.Heap.sort(a);
        else if (alg.equals("System"))          Arrays.sort(a);
        else throw new IllegalArgumentException("Invalid algorithm" + alg);

        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T)
    {
        double total = 0.0;
        Double[] a= new Double[N];
        for (int t = 0; t < T; t++)
        {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args)
    {
        String alg1 = "QuickX";
        String alg2 = "Heap";
        int n = 100000;
        int t = 100;

        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);

        StdOut.printf("%s : %.1f , %s : %.1f \n", alg1, t1, alg2, t2);
        StdOut.printf("For %d random Doubles\n    %s is", n, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }

}
