package com.bimo.OnlineExam;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: StreamTest
 * @Author: 13716
 * @Date: 2020/9/1 17:16
 * @Version: 1.0
 **/


public class StreamTest {
    @Test
    public void concatStream() {
        String[] a = {"123", "456"};
        String[] b = {"789", "0"};
        System.out.println(Stream.concat(Arrays.stream(a), Arrays.stream(b)).collect(Collectors.toList()));
    }
}
