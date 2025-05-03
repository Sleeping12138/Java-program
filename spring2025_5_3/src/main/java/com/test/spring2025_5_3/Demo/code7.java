package com.test.spring2025_5_3.Demo;

import java.util.LinkedHashMap;

public class code7 {
    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>(10,0.75f,true);
        map.put(1,1);
        map.put(2,1);
        map.put(3,1);
        map.put(4,1);
        map.put(5,1);
        map.put(6,1);

        Integer i = map.get(2);
        map.get(5);

        map.forEach((k,v)->{
            System.out.println(k+"---"+v);
        });

    }
}
