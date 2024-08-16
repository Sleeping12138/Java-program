package Demo2;

import java.util.ArrayList;

public class GraphByNode {
    static class Node {
        public int src;//起始位置
        public int dest;//目标位置
        public int weight;//权重
        public Node next;

        public Node(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public char[] arrayV;
    public ArrayList<Node> edgList;//存储边
    public boolean isDirect;

    public GraphByNode(int size,boolean isDirect) {
        this.arrayV = new char[size];
        edgList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            edgList.add(null);
        }
        this.isDirect = isDirect;
    }

    /**
     * 初始化顶点数组
     * @param array
     */
    public void initArrayV(char[] array) {
        for (int i = 0; i < array.length; i++) {
            arrayV[i] = array[i];
        }
    }

    /**
     * 添加边
     * @param srcV
     * @param destV
     * @param weight
     */
    public void addEdge(char srcV,char destV,int weight) {
        int srcIndex = getIndexOfV(srcV);
        int destIndex = getIndexOfV(destV);
        addEdgeChild(srcIndex,destIndex,weight);
        //无向图 需要添加两条边
        if(!isDirect) {
            addEdgeChild(destIndex,srcIndex,weight);
        }
    }

    private void addEdgeChild (int srcIndex , int destIndex,int weight) {
        //这里拿到是头节点
        Node cur = edgList.get(srcIndex);
        while (cur != null) {
            if(cur.dest == destIndex) {
                return;
            }
            cur = cur.next;
        }
        //之前没有存储过这条边
        Node node = new Node(srcIndex,destIndex,weight);
        node.next = edgList.get(srcIndex);
        edgList.set(srcIndex,node);
    }

    private int getIndexOfV(char v) {
        for (int i = 0; i < arrayV.length; i++) {
            if(arrayV[i] == v) {
                return i;
            }
        }
        return -1;
    }


    public void printGraph() {
        for (int i = 0; i < arrayV.length; i++) {
            System.out.print(arrayV[i]+"->");
            Node cur = edgList.get(i);
            while (cur != null) {
                System.out.print(arrayV[cur.dest]+" ->");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    /**
     * 获取顶点的度
     * @param v
     * @return
     */
    public int getDevOfV(char v) {
        int count = 0;
        int srcIndex = getIndexOfV(v);
        Node cur = edgList.get(srcIndex);

        while (cur != null) {
            count++;
            cur = cur.next;
        }


        //只是计算了出度
        if(isDirect) {
            int destIndex = srcIndex;
            for (int i = 0; i < arrayV.length; i++) {
                if(i == destIndex) {
                    continue;
                }else {
                    Node pCur = edgList.get(i);
                    while (pCur != null) {
                        if(pCur.dest == destIndex) {
                            count++;
                        }
                        pCur = pCur.next;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        GraphByNode graph = new GraphByNode(4,true);
        char[] array = {'A','B','C','D'};
        graph.initArrayV(array);

        graph.addEdge('A','B',1);
        graph.addEdge('A','D',1);
        graph.addEdge('B','A',1);
        graph.addEdge('B','C',1);
        graph.addEdge('C','B',1);
        graph.addEdge('C','D',1);
        graph.addEdge('D','A',1);
        graph.addEdge('D','C',1);

        System.out.println("getDevOfV:: "+graph.getDevOfV('A'));
        graph.printGraph();
    }

}
