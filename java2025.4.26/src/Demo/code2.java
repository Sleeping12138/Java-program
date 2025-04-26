package Demo;

import java.util.ArrayDeque;
import java.util.Deque;

public class code2 {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]) {
                ans[deque.peekLast()] = i - deque.peekLast();
                deque.pollLast();
            }

            deque.offerLast(i);
        }
        return ans;

    }
}
