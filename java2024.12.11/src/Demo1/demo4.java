package Demo1;

import java.util.Arrays;

class UFSet{
    public int[] node;

    public UFSet(int n) {
        node = new int[n];
        Arrays.fill(node,-1);
    }

    // 找根
    public int find(int val){
        if(node[val]<0) return val;

        node[val] = find(node[val]);
        return node[val];
    }

    // 合并两个集合
    public void merge(int val1,int val2){
        int root1 = find(val1);
        int root2 = find(val2);

        if(root1!=root2){
            if(node[root1]<node[root2]){
                node[root1]+=node[root2];
                node[root2] = root1;
            }else{
                node[root2]+=node[root1];
                node[root1] = root2;
            }
        }
    }

    // 查找两个元素是否属于一个集合
    public boolean isSameSet(int val1,int val2){
        return find(val1)==find(val2);
    }

    // 计算一共又几个集合
    public int sumSet(){
        int sum = 0;
        for(int i : node) {
            if(i<0) sum++;
        }
        return sum;
    }
}
