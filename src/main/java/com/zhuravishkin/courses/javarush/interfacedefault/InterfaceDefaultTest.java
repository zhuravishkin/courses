package com.zhuravishkin.courses.javarush.interfacedefault;

public class InterfaceDefaultTest implements InterfaceB {
    @Override
    public double getDouble() {
        return 5;
    }

    @Override
    public int getInt() {
        return 2;
    }

    public static void main(String[] args) {
        InterfaceDefaultTest interfaceDefault = new InterfaceDefaultTest();
        System.out.println(interfaceDefault.getBoolean());
        System.out.println(interfaceDefault.getDouble());
        System.out.println(interfaceDefault.getInt());
        System.out.println(InterfaceA.getStatic());
    }
}
