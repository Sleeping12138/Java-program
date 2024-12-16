package Demo1;

import java.util.Arrays;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        int[] array = new int[10010];
        int size = 0;
        for (int i = 0; i < N; i++) {
            String[] temp = in.nextLine().split(" ");
            for (String str : temp) {
                array[size++] = Integer.valueOf(str);
            }
        }
        Arrays.sort(array, 0, size);

//        System.out.println(Arrays.toString(array));

        int m = -1, n = -1;
        for (int now = 1; now < size; now++) {
            if (array[now - 1] + 1 != array[now] && m == -1) m = (array[now - 1] + array[now]) / 2;
            if (array[now - 1] == array[now] && n==-1) n = array[now];
        }
        System.out.println(m + " " + n);
    }
}
