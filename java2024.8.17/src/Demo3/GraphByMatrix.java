package Demo3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//使用邻接矩阵实现图
public class GraphByMatrix {
    //顶点数组
    public char[] arrayV;
    //邻接矩阵
    public int[][] matrix;
    //是否是有向图
    public boolean isDirect;
    public GraphByMatrix(int size,boolean isDirect){
        arrayV = new char[size];
        matrix = new int[size][size];
        for (int i = 0; i < arrayV.length; i++) {
            Arrays.fill(matrix[i],Constant.MAX);
        }
        this.isDirect = isDirect;
    }

    //初始化顶点数组
    public void initArrayV(char[] chars){
        for (int i = 0; i < chars.length; i++) {
            arrayV[i] = chars[i];
        }
    }

    //添加一条边
    public void insert(char src, char dest, int weight) {
        int srcIndex = getIndex(src);
        int destIndex = getIndex(dest);
        this.matrix[srcIndex][destIndex] = weight;

        if(!isDirect){
            this.matrix[destIndex][srcIndex] = weight;
        }
    }

    private int getIndex(char ch){
        for (int i = 0; i < arrayV.length; i++) {
            if(arrayV[i] == ch){
                return i;
            }
        }
        return -1;
    }

    //计算一个顶点的度
    public int getDevOfV(char ch){
        //如果是无向图
        int count = 0;
        int chIndex = getIndex(ch);
        for(int i = 0;i<arrayV.length;i++){
            if(matrix[chIndex][i]!=Constant.MAX){
                count+=matrix[chIndex][i];
            }
        }

        //如果为有向图
        if(isDirect){
            for (int i = 0; i < arrayV.length; i++) {
                if(matrix[i][chIndex]!=Constant.MAX){
                    count+=matrix[i][chIndex];
                }
            }
        }
        return count;
    }

    //打印邻接矩阵
    public void printGraph(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < arrayV.length; j++) {
                if(matrix[i][j]==Constant.MAX){
                    System.out.print("* ");
                }else{
                    System.out.print(matrix[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    //广度优先遍历
    public void BFS(char ch){
        int chIndex = getIndex(ch);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arrayV.length];

        queue.offer(chIndex);
        visited[chIndex] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(arrayV[temp]+" ");
            for (int i = 0; i < arrayV.length; i++) {
                if(matrix[temp][i] != Constant.MAX&& !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    //深度优先遍历 - 递归
    public void DFS(char ch) {
        int chIndex = getIndex(ch);
        boolean[] visited = new boolean[arrayV.length];
        DFSChild(chIndex,visited);
    }

    private void DFSChild(int chIndex, boolean[] visited) {
        System.out.print(arrayV[chIndex]+" ");
        visited[chIndex] = true;
        for (int i = 0; i < arrayV.length; i++) {
            if(matrix[chIndex][i]!=Constant.MAX&&!visited[i]){
                DFSChild(i, visited);
            }
        }
    }

}
