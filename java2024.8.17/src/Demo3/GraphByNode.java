package Demo3;

//使用邻接表来实现图
public class GraphByNode {
    public static class Node{
        public int src;
        public int dest;
        public int weight;
        public Node next;

        public Node(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public char[] arrayV;
    public Node[] nodes;
    public boolean isDirect;

    public GraphByNode(int size, boolean isDirect) {
        arrayV = new char[size];
        nodes = new Node[size];
        this.isDirect = isDirect;
    }

    public void initArrayV(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            arrayV[i] = chars[i];
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

    //添加边
    public void insert(char src, char dest, int weight){
        int srcIndex = getIndex(src);
        int destIndex = getIndex(dest);
        insertChild(srcIndex, destIndex, weight);

        if (!isDirect) {
            insertChild(destIndex, srcIndex, weight);
        }
    }

    private void insertChild(int srcIndex, int destIndex, int weight) {
        Node cur = nodes[srcIndex];
        while (cur != null) {
            if (cur.dest == destIndex) {
                return;
            }
            cur =cur.next;
        }

        Node node = new Node(srcIndex, destIndex, weight);
        node.next = nodes[srcIndex];
        nodes[srcIndex] = node;
    }

    //计算顶点的度
    public int getDevOfV(char ch) {
        int chIndex = getIndex(ch);
        Node cur = nodes[chIndex];
        int count = 0;
        while (cur != null) {
            count += cur.weight;
            cur = cur.next;
        }

        if (isDirect) {
            for (int i = 0; i < arrayV.length; i++) {
                if(i == chIndex){
                    continue;
                }else{
                    Node pcur = nodes[i];
                    while (pcur != null) {
                        if(pcur.dest == chIndex){
                            count+=pcur.weight;
                        }
                        pcur = pcur.next;
                    }
                }
            }
        }
        return count;
    }

    //打印邻接表
    public void printGraph(){
        for (int i = 0; i < nodes.length; i++) {
            System.out.print(arrayV[i]+"-> ");
            Node cur = nodes[i];
            while (cur != null) {
                System.out.print(arrayV[cur.dest]+" ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
