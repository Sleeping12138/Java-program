package Demo1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    private Map<String, Integer> map = new HashMap<>();
    private int[] node;

    public UnionFind(int n) {
        node = new int[n];
        Arrays.fill(node,-1);
    }

    public int find(String element) {
        if (!map.containsKey(element)) {
            int newIndex = map.size();
            map.put(element, newIndex);
        }

        int index = map.get(element);
        return findRoot(index);
    }

    public int findRoot(int val){
        if(node[val]<0) return val;

        node[val] = findRoot(node[val]);
        return node[val];
    }

    public void merge(String val1,String val2){
        int r1 = find(val1),r2 = find(val2);
        if (r1 != r2) {
            if(node[r1]<node[r2]){
                node[r1]+=node[r2];
                node[r2]=r1;
            }else{
                node[r2]+=node[r1];
                node[r1]=r2;
            }
        }
    }

    // 集合个数
    public int sumSet(){
        int sum = 0;
        for(int number : node){
            if(number<0) sum++;
        }
        return sum;
    }

}
