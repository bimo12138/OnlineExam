package com.bimo.OnlineExam.utils;

import java.util.Arrays;

/**
 * @ClassName: StringAndIntConversion
 * @Author: 13716
 * @Date: 2020/9/1 14:59
 * @Version: 1.0
 **/


public class StringAndIntConversion {
    public static int[] getInts(String raw) {
        if (raw.equals("")) return null;
        if (raw.length() == 1) return new int[] {Integer.parseInt(raw)};
        String[] res = raw.split("-");
        return Arrays.stream(res).mapToInt(Integer::valueOf).toArray();
    }
}
