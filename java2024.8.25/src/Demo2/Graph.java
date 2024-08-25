package Demo2;

//图 - 邻接表
public class Graph {
    public static class Node {
        public int src;
        public int dest;
        public int weigth;
        public Node next;

        public Node(int src, int dest, int weigth) {
            this.src = src;
            this.dest = dest;
            this.weigth = weigth;
        }
    }

    public char[] arrayV;
    public Node[] nodes;
    public boolean isDirect;

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
        addEdgeChild(index1, index2, weight);
        if (!isDirect) {
            addEdgeChild(index2, index1, weight);
        }
    }

    private void addEdgeChild(int index1, int index2, int weight) {
        Node cur = nodes[index1];
        while (cur != null) {
            if (cur.dest == index2) {
                cur.weigth = weight;
                return;
            }
            cur = cur.next;
        }
        Node newNode = new Node(index1, index2, weight);
        newNode.next = nodes[index1];
        nodes[index1] = newNode;
    }

    private int getIndex(char ch) {
        for (int i = 0; i < arrayV.length; i++) {
            if (arrayV[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    //获取节点的度
    public int getDevOfV(char ch) {
        int index = getIndex(ch);
        Node cur = nodes[index];
        int count = 0;
        while (cur != null) {
            count += cur.weigth;
            cur = cur.next;
        }
        if (isDirect) {
            for (int i = 0; i < arrayV.length; i++) {
                if (i == index) {
                    continue;
                } else {
                    Node pcur = nodes[i];
                    while (pcur != null) {
                        if (pcur.dest == index) {
                            count += pcur.weigth;
                        }
                        pcur = pcur.next;
                    }
                }

            }
        }
        return count;
    }

    //打印邻接表
    public void print() {
        for (int i = 0; i < arrayV.length; i++) {
            System.out.print(arrayV[i] + ":");
            Node cur = nodes[i];
            while (cur != null) {
                System.out.print(cur.dest + " -> ");
                cur = cur.next;
            }
        }
        System.out.println();
    }
}
