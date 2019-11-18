package com.basic.java.container;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * 集合示例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\3 0003 9:23
 */
public class ListDemo {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("张飞");
        coll.add("关羽");
        coll.add("刘备");
        System.out.println(coll);
        Object[] bros = coll.toArray();
        System.out.println(Arrays.toString(bros));
        System.out.println(Arrays.binarySearch(bros,"张飞"));

        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("end");
        System.out.println(list);


    }
}
