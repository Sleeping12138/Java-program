package Demo2;

import java.util.Arrays;

//图 - 邻接矩阵
public class GraphByMatrix {
    public char[] arrayV;
    public int[][] matrix;
    public boolean isDirect;
    public static final int MAX = Integer.MAX_VALUE;

    public GraphByMatrix(int size, boolean isDirect) {
        arrayV = new char[size];
        matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], MAX);
        }
        this.isDirect = isDirect;
    }

    //初始化顶点数组
    public void initialArrayV(char[] chs) {
        for (int i = 0; i < chs.length; i++) {
            arrayV[i] = chs[i];
        }
    }

    //添加边
    public void addEdge(char v1, char v2, int weight) {
        int index1 = getIndex(v1);
        int index2 = getIndex(v2);
        matrix[index1][index2] = weight;
        if (!isDirect) {
            matrix[index2][index1] = weight;
        }
    }

    //获取索引值
    private int getIndex(char ch) {
        for (int i = 0; i < arrayV.length; i++) {
            if (arrayV[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    //获取节点的度
    public int getDeevOfV(char ch) {
        int index = getIndex(ch);
        int count = 0;
        for (int i = 0; i < arrayV.length; i++) {
            if (matrix[index][i] != MAX) {
                count += matrix[index][i];
            }
        }
        if (isDirect) {
            for (int i = 0; i < arrayV.length; i++) {
                if (matrix[i][index] != MAX) {
                    count += matrix[i][index];
                }
            }
        }
        return count;
    }

    //打印邻接矩阵
    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != MAX) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

}
