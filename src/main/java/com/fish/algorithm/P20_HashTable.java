/*
 * @Title P20_HashTable.java
 */
package com.fish.algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 散列表
 * @date 2020/12/26 19:17
 */
public class P20_HashTable {

    public static void main(String[] args) {
        linkedHashMapTest();
    }


    public static void linkedHashMapTest() {
        HashMap<Integer, Integer> m = new LinkedHashMap<>(4);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            System.err.println(e.getKey());
        }

        System.err.println("------------------");

        HashMap<Integer, Integer> m2 = new HashMap<>(4);
        m2.put(3, 11);
        m2.put(1, 12);
        m2.put(5, 23);
        m2.put(2, 22);
        for (Map.Entry<Integer, Integer> e : m2.entrySet()) {
            System.err.println(e.getKey());
        }


        System.err.println("------------------");


        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        HashMap<Integer, Integer> m3 = new LinkedHashMap<>(10, 0.75f, true);
        m3.put(3, 11);
        m3.put(1, 12);
        m3.put(5, 23);
        m3.put(2, 22);

        m3.put(3, 26);
        m3.get(5);
        for (Map.Entry<Integer, Integer> e : m3.entrySet()) {
            System.err.println(e.getKey());
        }
    }

}
