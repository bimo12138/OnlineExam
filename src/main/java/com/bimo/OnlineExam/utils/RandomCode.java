package com.bimo.OnlineExam.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName: RandomCode
 * @Author: 13716
 * @Date: 2020/8/8 21:35
 * @Version: 1.0
 **/

public class RandomCode {
    private final static Random random = new Random();
    static char[] values = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78,
            79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    private static void swap(char[] array, int i, int j) {
        if (i != j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static String getRandomCode() {
        for (int i = values.length; i > 1; i --) {
            swap(values, i-1, random.nextInt(values.length));
        }
        return String.valueOf(Arrays.copyOf(values, 6));
    }
}
