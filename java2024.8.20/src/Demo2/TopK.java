package Demo2;

import java.util.PriorityQueue;
public class TopK {
    public int[] maxHeap(int[] array, int k) {
        if (k <= 0) {
            throw new KIsError("k为负数！");
        }
        LessIntComp lessIntComp = new LessIntComp();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(lessIntComp);
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            if(priorityQueue.peek()<array[k]){
                priorityQueue.poll();
                priorityQueue.offer(array[k]);
            }
        }

        int ret[] = new int[k];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = priorityQueue.poll();
        }

        return ret;


    }
}
