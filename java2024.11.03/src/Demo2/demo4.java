package Demo2;

import java.util.Scanner;

public class demo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt(), k = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int i = 0; i < n; i++) b[i] = in.nextInt();

            int[] sumA = new int[n];
            int[] sumB = new int[n];

            sumA[0] = a[0];
            sumB[0] = b[0];

            for (int i = 1; i < n; i++) {
                sumA[i] = sumA[i - 1] + a[i];
                sumB[i] = sumB[i - 1] + b[i];
            }

            int beginning =  0,maxHappy = sumA[k-1],minShame = sumB[k-1];
            for(int i = 1;i+k-1<n;i++){
                int happy = sumA[i+k-1]-sumA[i-1];
                int shame = sumB[i+k-1]-sumB[i-1];
                if(happy>maxHappy){
                    maxHappy = happy;
                    beginning = i;
                    minShame = shame;
                }else if(happy==maxHappy&&shame<minShame){
                    beginning = i;
                    minShame = shame;
                }
            }

            System.out.println(beginning+1);
        }
    }
}
