package com.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFirstTest {

    @Test
    public void myFirstTest() {
        int result = sum(2, 3);
        System.out.println("It runs!");

        Assertions.assertEquals(4,result);
    }

    static int sum(int a, int b) {
        return a + b;
    }
}
