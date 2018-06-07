package edu.princeton.cs.exercise.chapter1_2;

import edu.princeton.cs.algs4.*;

public class Interval2D {
    private final Interval1D x;
    private final Interval1D y;

    public Interval2D(Interval1D x, Interval1D y) {
        this.x = x;
        this.y = y;
    }

    // does this interval intersect that one?
    public boolean intersects(Interval2D that) {
        if (!this.x.intersects(that.x)) return false;
        if (!this.y.intersects(that.y)) return false;
        return true;
    }

    // does this interval contain x?
    public boolean contains(Point2D p) {
        return x.contains(p.x())  && y.contains(p.y());
    }

    // area of this interval
    public double area() {
        return x.length() * y.length();
    }

    public String toString() {
        return x + " x " + y;
    }

    // test client
    public static void main(String[] args) {
        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);
        double yhi = Double.parseDouble(args[3]);
        int T = Integer.parseInt(args[4]);

        StdDraw.setCanvasSize(1024, 1024);

        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);

        double xc = (xhi + xlo) / 2.0;
        double yc = (yhi + ylo) / 2.0;
        StdDraw.rectangle(xc, yc, (xhi - xlo) / 2.0, (yhi - ylo) / 2.0);

        StdDraw.setPenRadius(.005);

        Counter counter = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);

            if (box.contains(p)) counter.increment();
            //else                 p.draw();
            p.draw();
        }

        StdOut.println(counter);
        StdOut.printf("box area = %.2f\n", box.area());
    }
}
