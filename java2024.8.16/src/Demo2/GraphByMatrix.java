package Demo2;

import java.util.Arrays;

//使用邻接矩阵
public class GraphByMatrix {

    private char[] arrayV;//顶点数组
    private int[][] matrix;//矩阵
    private boolean isDirect;//是否是有向图

    /**
     * 此时
     *
     * @param size     代表当前顶点的个数
     * @param isDirect
     */
    public GraphByMatrix(int size, boolean isDirect) {
        this.arrayV = new char[size];
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(matrix[i], Constant.MAX);
        }
        this.isDirect = isDirect;
    }

    public void initArrayV(char[] array) {
        for (int i = 0; i < array.length; i++) {
            arrayV[i] = array[i];
        }
    }

    /**
     * @param srcV   起点
     * @param destV  终点
     * @param weight 权值
     */
    public void addEdge(char srcV, char destV, int weight) {
        int srcIndex = getIndexOfV(srcV);
        int destIndex = getIndexOfV(destV);
        matrix[srcIndex][destIndex] = weight;
        //如果是无向图 那么相反的位置 也同样需要置为空
        if (!isDirect) {
            matrix[destIndex][srcIndex] = weight;
        }
    }

    /**
     * 获取顶点V的下标
     *
     * @param v
     * @return
     */
    private int getIndexOfV(char v) {
        for (int i = 0; i < arrayV.length; i++) {
            if (arrayV[i] == v) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取顶点的度：有向图 = 入度+出度
     *
     * @param v
     * @return
     */
    public int getDevOfV(char v) {
        int count = 0;

        int srcIndex = getIndexOfV(v);

        for (int i = 0; i < arrayV.length; i++) {
            if (matrix[srcIndex][i] != Constant.MAX) {
                count++;
            }
        }

        //计算有向图的入度
        if (isDirect) {
            for (int i = 0; i < arrayV.length; i++) {
                if (matrix[i][srcIndex] != Constant.MAX) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printGraph() {
        for (int i = 0; i < arrayV.length; i++) {
            System.out.print(arrayV[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == Constant.MAX) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
