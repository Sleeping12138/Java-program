package Demo1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0;i<=n;i++) queue.offer(n);
            while(queue.size()!=1){
                int index = 0,size = queue.size();
                for(int i = 0;i<size;i++){
                    int top = queue.poll();
                    if(index%2==1) queue.offer(top);
                    index++;
                }
            }
            System.out.println(queue.poll());
        }
    }
}
