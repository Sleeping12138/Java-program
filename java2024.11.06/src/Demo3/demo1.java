package Demo3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt(), m = in.nextInt();
            int[] A = new int[n];
            int[] B = new int[m];
            for (int i = 0; i < n; i++) A[i] = in.nextInt();
            for (int i = 0; i < m; i++) B[i] = in.nextInt();
            Arrays.sort(A);
            Arrays.sort(B);

            int leftA = 0, leftB = 0, tailNumber = 0, index = 0;
            while (leftA < n && leftB < m) {
                if (A[leftA] <= B[leftB]) {
                    if (tailNumber < A[leftA]) {
                        if (index == 0) {
                            System.out.print(A[leftA]);
                        } else {
                            System.out.print(" " + A[leftA]);
                        }
                        tailNumber = A[leftA];
                    }
                    leftA++;
                    index++;
                } else {
                    if (tailNumber < B[leftB]) {
                        if (index == 0) {
                            System.out.print(B[leftB]);
                        } else {
                            System.out.print(" " + B[leftB]);
                        }
                        tailNumber = B[leftB];
                    }
                    leftB++;
                    index++;
                }
            }
            while (leftA < n) {
                if (tailNumber < A[leftA]) {
                    System.out.print(" " + A[leftA]);
                    tailNumber = A[leftA];
                }
                leftA++;
            }
            while (leftB < m) {
                if (tailNumber < B[leftB]) {
                    System.out.print(" " + B[leftB]);
                    tailNumber = B[leftB];
                }
                leftB++;
            }
            System.out.println();
        }

    }
}
