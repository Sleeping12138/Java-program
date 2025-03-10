package com.test.spring2025_3_10.Demo1;

import java.util.Arrays;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int n = in.nextInt(),m = in.nextInt();
//            int top = getNum(n,m),bottom = getNum(m,m);
//            double ret = (top*1.0/bottom)*Math.pow(0.8,m)*Math.pow(0.2,n-m);
//            System.out.printf("%.4f",ret);
//        }
//        System.out.println(Integer.MAX_VALUE);

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt(),l = in.nextInt(),r = in.nextInt();
            int[] array = new int[n];
            for(int i = 0;i<n;i++) array[i]=in.nextInt();
            Arrays.sort(array);

            int sum = 0;
            for(int i = n-1;i>0;i--){
                int left = 0,right = i;
                while(left<right){
                    int mid = (left+right)/2;
                    int ret = array[right]-array[mid];
                    if(ret>=l&&ret<=r) left = mid+1;
                    else right = mid -1;
                }
                int finalRight = right;

                left = 0;right = i;
                while(left<right){
                    int mid = (left+right)/2;
                    int ret = array[right]-array[mid];
                    if(ret>=l&&ret<=r) right = mid-1;
                    else left = mid +1;
                }
                int finalLeft = right;
                sum+=finalRight-finalLeft+1;
            }

            System.out.println(sum);
        }
    }

    public static int getNum(int begin,int num){
        int sum = 1,number= begin;
        for(int i = 0;i<num;i++){
            sum*=number;
            number--;
        }
        return sum;
    }
}
