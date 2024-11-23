package Demo2;

import java.util.Scanner;

public class demo1 {
    public static int minNum = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case


                int number = in.nextInt() - 1;
                dfs(number,1,1);
                System.out.println(minNum);
                minNum = Integer.MAX_VALUE;

        }
    }
    public static void dfs(int number,int now,int ret){
        if(number<0) return;
        if(number==0){
            minNum = Math.min(minNum,ret);
            return;
        }

        dfs(number-now,now,ret+1);
        dfs(number-2*now,2*now,ret+1);
    }
}
