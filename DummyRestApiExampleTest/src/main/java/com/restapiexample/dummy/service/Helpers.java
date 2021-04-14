package com.restapiexample.dummy.service;

import java.util.UUID;

public class Helpers {

    public static int randomIntGenerator(int min, int max) {
        final java.util.Random random = new java.util.Random();

        return random.nextInt(max - min) + min;
    }

    public static String randomStringGenerator() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
