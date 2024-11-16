package Demo1;

import java.util.*;

// 图的创建 + 图的深搜 + 图的宽搜
public class Graph {
    private static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    private static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        initMap();
        map.get(1).add(2);
        map.get(1).add(3);
        map.get(1).add(4);
        map.get(2).add(5);
        map.get(3).add(5);
        map.get(4).add(5);

//        dfs(1);
        bfs(1);
    }

    public static void initMap() {
        for (int i = 1; i <= 5; i++) {
            map.put(i, new ArrayList<Integer>());
        }
    }

    public static void dfs(int number) {
        System.out.print(number+" -> ");
        set.add(number);
        for(int next : map.get(number)){
            if(!set.contains(next)){
                dfs(next);
            }
        }
        System.out.println();
    }

    public static void bfs(int number){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(number);
        set.add(number);

        while (!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp+" -> ");
            for(int next : map.get(temp)){
                if(!set.contains(next)){
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
    }
}
