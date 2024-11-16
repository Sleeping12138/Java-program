package Demo1;

import java.util.*;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = in.nextInt(),m = in.nextInt();
        for(int i = 1;i<=n;i++){
            map.put(i,new ArrayList<Integer>());
        }

        for(int i = 0;i<m;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            map.get(a).add(b);
        }

        int[] pathLen = new int[n+1];
        boolean[] vis = new boolean[n+1];

        Queue<Integer> queue= new LinkedList<>();
        queue.offer(1);
        vis[1] = true;

        while (!queue.isEmpty()){
            int temp = queue.poll();
            for(int number : map.get(temp)){
                if(!vis[number]){
                    queue.offer(number);
                    vis[number] = true;
                    pathLen[number] = pathLen[temp]+1;
                    if(number == n) break;
                }
            }
        }

        if(n==1){
            System.out.println(0);
        }else{
            System.out.println(pathLen[n]==0?-1:pathLen[n]);
        }

    }
}
