package Demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 树/图的存储
public class demo2 {
    public static void main(String[] args) {
        // 使用邻接表
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 1;i<=5;i++){
            map.put(i,new ArrayList<Integer>());
        }

        // 初始化 - 添加节点
        map.get(1).add(2);
        map.get(1).add(3);
        map.get(1).add(4);
        map.get(3).add(5);

        for(int i = 1;i<=5;i++){
            System.out.print(i+" : ");
            for(int number : map.get(i)){
                System.out.print(number+" ");
            }
            System.out.println();
        }
    }
}
