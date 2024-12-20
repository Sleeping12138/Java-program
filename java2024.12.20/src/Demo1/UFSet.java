package Demo1;

import java.util.Arrays;

public class UFSet {
    public int[] node;

    public UFSet(int n) {
        node = new int[n];
        Arrays.fill(node,-1);
    }

    // 找根节点
    public int find(int val){
        if(node[val]<0) return val;

        node[val] = find(node[val]);
        return node[val];
    }

    // 合并两个集合
    public void merge(int val1,int val2){
        int r1 = find(val1),r2 = find(val2);
        if (r1 != r2) {
            if(r1<r2){
                node[r1]+=node[r2];
                node[r2]=r1;
            }else{
                node[r2]+=node[r1];
                node[r1]=r2;
            }
        }
    }

    // 查看是否属于同一个集合
    public boolean isSame(int val1,int val2){
        return find(val1)==find(val2);
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
