package com.bimo.OnlineExam.utils;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateTest
 * @Author: 13716
 * @Date: 2020/7/25 16:55
 * @Version: 1.0
 **/


public class DateTest {
    @Test
    public void test() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String new_date = simpleDateFormat.format(new Date());
        System.out.println(new_date);
    }
}
