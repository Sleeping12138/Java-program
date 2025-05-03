package com.test.spring2025_5_3.Demo;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class code4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

//        int[] array = list.stream().mapToInt(num -> num.intValue()).toArray();
//        System.out.println(Arrays.toString(array));
        //

        OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
        if(average.isPresent()){
            System.out.println("有值");
        }else{
            System.out.println("没值");
        }



//        int sum = list.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(sum);
    }
}
