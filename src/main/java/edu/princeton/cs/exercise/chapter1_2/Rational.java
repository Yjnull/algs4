package edu.princeton.cs.exercise.chapter1_2;

import edu.princeton.cs.algs4.StdOut;

public class Rational implements Comparable<Rational> {
    private static Rational zero = new Rational(0, 1);

    private long numerator;    //分子
    private long denominator;  //分母

    public Rational(long num, long den) {

        if (den == 0)
            throw new RuntimeException("Denominator is zero");

        //约分
        long g = gcd(num, den);
        numerator = num / g;
        denominator = den / g;

        if (denominator < 0) {
            denominator = - denominator;
            numerator = - numerator;
        }

    }

    //最大公约数 return gcd(|p|, |q|)
    private static long gcd(long p, long q) {
        if (p < 0) p = -p;
        if (q < 0) q = -q;
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    //最小公倍数
    private static long lcm(long p, long q) {
        if (p < 0) p = -p;
        if (q < 0) q = -q;
        return p * (q / gcd(p, q));
    }

    public String toString() {
        if (denominator == 1) return numerator + "";
        else                  return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Rational b = (Rational) y;
        return compareTo(b) == 0;
    }

    @Override
    public int compareTo(Rational that) {
        long lhs = this.numerator * that.denominator;
        long rhs = this.denominator * that.numerator;
        if (lhs > rhs)      return +1;
        else if (lhs < rhs) return -1;
        else                return 0;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    /**
     * 该数与 that 之和
     * @param b
     * @return
     */
    public Rational plus(Rational b) {
        //special cases
        if (this.compareTo(zero) == 0) return b;
        if (b.compareTo(zero) == 0) return this;

        //找到最大公约数
        long f = gcd(this.numerator, b.numerator);
        long g = gcd(this.denominator, b.denominator);

        Rational s = new Rational( (this.numerator / f) * (b.denominator / g) + (b.numerator / f) * (this.denominator / g),
                lcm(this.denominator, b.denominator));

        s.numerator *= f;
        return s;
    }

    // return -this
    public Rational negate() {
        return new Rational(-numerator, denominator);
    }

    /**
     * 该数与 that 之差
     * @param b
     * @return
     */
    public Rational minus(Rational b) {
        return this.plus(b.negate());
    }

    /**
     * 乘积
     * @param b
     * @return
     */
    public Rational times(Rational b) {
        Rational c = new Rational(this.numerator, b.denominator);
        Rational d = new Rational(b.numerator, this.denominator);
        return new Rational(c.numerator * d.numerator, c.denominator * d.denominator);
    }

    public Rational reciprocal() { return new Rational(denominator, numerator);  }
    /**
     * 商
     * @param b
     * @return
     */
    public Rational divides(Rational b) {
        return this.times(b.reciprocal());
    }


    public static void main(String[] args) {
        Rational x, y, z;

        // 1/2 + 1/3 = 5/6
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z = x.plus(y);
        StdOut.println(z);

        // 8/9 + 1/9 = 1
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.plus(y);
        StdOut.println(z);

        // 1/200000000 + 1/300000000 = 1/120000000
        x = new Rational(1, 200000000);
        y = new Rational(1, 300000000);
        z = x.plus(y);
        StdOut.println(z);

        // 1073741789/20 + 1073741789/30 = 1073741789/12
        x = new Rational(1073741789, 20);
        y = new Rational(1073741789, 30);
        z = x.plus(y);
        StdOut.println(z);

        //  4/17 * 17/4 = 1
        x = new Rational(4, 17);
        y = new Rational(17, 4);
        z = x.times(y);
        StdOut.println(z);

        // 3037141/3247033 * 3037547/3246599 = 841/961
        x = new Rational(3037141, 3247033);
        y = new Rational(3037547, 3246599);
        z = x.times(y);
        StdOut.println(z);

        // 1/6 - -4/-8 = -1/3
        x = new Rational(1, 6);
        y = new Rational(-4, -8);
        z = x.minus(y);
        StdOut.println(z);
    }
}
