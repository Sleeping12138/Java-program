package Demo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class code3 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>((int[] m, int[] n) -> m[1] - n[1]);
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey(), value = entry.getValue();
                if (index < k) {
                    queue.offer(new int[]{key, value});
                } else {
                    if (queue.peek()[1] < value) {
                        queue.poll();
                        queue.offer(new int[]{key, value});
                    }
                }
                index++;
            }

            int[] ret = new int[k];
            for (int i = 0; i < k; i++) {
                ret[i] = queue.poll()[0];
            }

            return ret;

        }
    }
}
