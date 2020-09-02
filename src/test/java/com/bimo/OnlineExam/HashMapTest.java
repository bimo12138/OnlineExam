package com.bimo.OnlineExam;

import org.apache.velocity.util.introspection.Uberspect;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: HashMapTest
 * @Author: 13716
 * @Date: 2020/8/12 9:04
 * @Version: 1.0
 **/


public class HashMapTest {

    @Test
    public void testMain() {
        System.out.println("start");
        List<String> news = new ArrayList<String>();
        news.add("123");
        news.add("456");
        news.add("456");
        news.add("456");
        news.add("456");
        news.add("456");
        news.add("456");
        news.add("456");
        news.add("456");
        news.add("456");
        news.add("456");
    }

    @Test
    public void testHash() {
        System.out.println("start");
        HashMap<String, Object> maps = new HashMap<String, Object>();
        maps.put("1", "123");
        maps.put("2", "456");
        maps.put("1", "789");
        maps.get("1");
        maps.get("2");
        maps.put("3", "987");
        maps.remove("3");
    }

    @Test
    public void testKub() {
        String s = "abc";
        String t = "ahbgdc";

        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                System.out.println(false);
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        System.out.println(true);
     }
}
