package Demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class code {
    public static void main(String[] args) {
        PriorityQueue<Map<Integer,Integer>> priorityQueue = new PriorityQueue<>();

    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Integer[] number = new Integer[n+10];
        for(int num : nums){
            number[num]++;
        }

        Arrays.sort(number, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });


        int[] ret = new int[k];
        for(int i = 0;i<k;i++){
            ret[i] = number[i];
        }

        return ret;

    }
}
