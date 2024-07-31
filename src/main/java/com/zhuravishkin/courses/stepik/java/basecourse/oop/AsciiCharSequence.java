package com.zhuravishkin.courses.stepik.java.basecourse.oop;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private final byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    public static void main(String[] args) {
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(new byte[]{52, 53, 54});
        System.out.println(asciiCharSequence.subSequence(1, 2));
        System.out.println(asciiCharSequence);
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(bytes, start, end));
    }

    @Override
    public String toString() {
        return new String(bytes);
    }
}
