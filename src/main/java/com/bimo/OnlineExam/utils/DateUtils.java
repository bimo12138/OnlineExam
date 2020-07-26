package com.bimo.OnlineExam.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateUtils
 * @Author: 13716
 * @Date: 2020/7/25 17:10
 * @Version: 1.0
 **/


public class DateUtils {
    /**
     * DATE_FORMAT 数据库的时间格式
     */
    private final static String DATE_FORMAT = "yyy-MM-dd";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    /**
     * 将 new Date() 等格式的时间 转化为 数据库中的 Date 的格式
     * @param date 一般传入的值为 new Date()
     * @return 返回符合数据库的 Date 对象的值
     */
    public static String parseDate(Date date) {
        return simpleDateFormat.format(date);
    }
}
