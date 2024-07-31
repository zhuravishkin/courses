package com.zhuravishkin.courses.javarush;

public class CastTest {
    private int a;

    public CastTest(int a) {
        this.a = a;
    }

    void test(double d) {
        System.out.println("double: " + d);
    }

//    void test(int d) {
//        System.out.println("int: " + d);
//    }

    void meth(CastTest castTest) {
        castTest.a *= 10;
    }

    public static void main(String[] args) {
        int a = 35;
        CastTest castTest = new CastTest(4);
        castTest.test(a);
        System.out.println(castTest.a);
        castTest.meth(castTest);
        System.out.println(castTest.a);
    }
}
