package com.bimo.OnlineExam;

import com.bimo.OnlineExam.utils.RandomCode;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @ClassName: FileTest
 * @Author: 13716
 * @Date: 2020/7/31 18:23
 * @Version: 1.0
 **/


public class FileTest {
    @Test
    public void getPath() {
        System.out.println(System.getProperty("user.dir") + "\\src\\main\\resources\\media\\excel");
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    public void template(int n) {
        int num= (int)(n / 2) * -1;
        if (n % 2 == 1) {
            num += n;
        }
        System.out.println(num);
    }

    @Test
    public void templateOneMain() {
        boolean result = templateOne(new int[]{3,2,1,0,4}, 0);
        System.out.println(result);
    }
    @Test
    public boolean templateOne(int[] paths, int flag) {
        if (paths.length == 1) {
            return true;
        }
        if (paths[flag] == 0) {
            return false;
        }
        return templateOne(Arrays.copyOfRange(paths, flag, paths.length - 1), paths[flag]);
    }

    @Test
    public void templateTwo() {
        int[] ways = new int[]{4, 5, 6, 5, 6, 7, 8, 9, 10, 9};
        int result = templateTwoMain(ways, 9, 0);
        System.out.println(result);
    }

    @Test
    public int templateTwoMain(int[] ways, int num, int index) {
        if (ways[index] == num) {
            return index;
        }
        int tmp = Math.abs(ways[index] - num);
        return templateTwoMain(ways, num, index + tmp);
    }

    private void swap(char[] array, int i, int j) {
        if (i != j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    @Test
    public void templateThreeMain() {
        Random random = new Random();

        char[] values = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78,
                79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
                111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        for (int i = values.length; i > 1; i --) {
            swap(values, i-1, random.nextInt(values.length));
        }
        System.out.println(Arrays.copyOf(values, 6));
    }


    @Test
    public void getOne() {
        System.out.println(RandomCode.getRandomCode());
    }

    @Test
    public void getText() {
        System.out.println(LocalDateTime.now());
    }
}
