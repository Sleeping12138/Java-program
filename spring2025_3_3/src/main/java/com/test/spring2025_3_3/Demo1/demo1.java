package com.test.spring2025_3_3.Demo1;

public class demo1 {
    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        System.out.println(totalFruit(fruits));
    }
    public static int totalFruit(int[] fruits) {
        int n = fruits.length, num = 0, left = 0, maxNum = 0;
        int[] kind = new int[n];

        for (int right = 0; right < n; right++) {
            if (kind[fruits[right]] == 0)
                num++;
            kind[fruits[right]]++;

            while (num > 2) {
                kind[fruits[left]]--;
                if (kind[fruits[left]] == 0)
                    num--;
                left++;
            }

            maxNum = Math.max(maxNum, right - left + 1);
        }
        return maxNum;
    }
}
