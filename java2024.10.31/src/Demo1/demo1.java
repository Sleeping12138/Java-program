package Demo1;

import java.util.HashMap;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt(), m = in.nextInt();
            int[] array = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                int number = map.getOrDefault(array[i], 0) + 1;
                max = Math.max(number, max);
                map.put(array[i], number);
            }

            boolean flag = false;
            for (int i = 1; i <= max; i++) {
                int teamNumber = 0;
                for (int people : map.values()) {
                    teamNumber += people / i + (people % i == 0 ? 0 : 1);
                }
                if (teamNumber <= m) {
                    System.out.println(i);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println(-1);
            }
        }
    }
}
