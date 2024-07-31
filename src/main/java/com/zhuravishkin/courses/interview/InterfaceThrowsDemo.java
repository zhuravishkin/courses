package com.zhuravishkin.courses.interview;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;

public class InterfaceThrowsDemo implements A, B {
    @Override
    public void copy() throws FileNotFoundException, InterruptedIOException {

    }
}

interface A {
    void copy() throws IOException, IllegalArgumentException;
}

interface B {
    void copy() throws FileNotFoundException, InterruptedIOException;
}
