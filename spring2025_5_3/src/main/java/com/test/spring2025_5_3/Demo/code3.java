package com.test.spring2025_5_3.Demo;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

public class code3 {
    public static void main(String[] args) {
        Object str = "hello";
        if (str instanceof String s) {
            str = s + " world";
        }

//        CollectionUtils.isEmpty();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list);

    }
}
