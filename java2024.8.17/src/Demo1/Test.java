package Demo1;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedList<>();
//
//        Deque<Integer> deque = new LinkedList<>();
//        Deque<Integer> deque1 = new ArrayDeque<>();
//
//        Stack<Integer> stack = new Stack<>();

        int[] array  = {5,1,1,1};
        int time = timeRequiredToBuy(array, 0);
        System.out.println(time);


    }
    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<tickets.length;i++){
            queue.offer(tickets[i]);
        }

        int time = 0;
        int index = 0;
        while(tickets[k]!=0){
            if(queue.peek()!=0){
                tickets[index] = queue.poll() - 1;
                queue.offer(tickets[index]);
                index = (index+1)%tickets.length;
                time++;
            }else{
                queue.offer(queue.poll());
                index = (index+1)%tickets.length;
            }
        }
        return time;
    }
}
