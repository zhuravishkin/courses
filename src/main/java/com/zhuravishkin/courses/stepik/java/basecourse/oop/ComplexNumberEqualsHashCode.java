package com.zhuravishkin.courses.stepik.java.basecourse.oop;

public class ComplexNumberEqualsHashCode {
    private final double re;
    private final double im;

    public ComplexNumberEqualsHashCode(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        return (obj instanceof ComplexNumberEqualsHashCode) &&
                (re == ((ComplexNumberEqualsHashCode) obj).re) &&
                (im == ((ComplexNumberEqualsHashCode) obj).im);
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(re + im);
        return (int) (bits ^ (bits >>> 32));
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ComplexNumberEqualsHashCode that = (ComplexNumberEqualsHashCode) o;
//        return Double.compare(that.re, re) == 0 && Double.compare(that.im, im) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(re, im);
//    }

    public static void main(String[] args) {
        ComplexNumberEqualsHashCode a = new ComplexNumberEqualsHashCode(1, 1);
        ComplexNumberEqualsHashCode b = new ComplexNumberEqualsHashCode(1, 1);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
