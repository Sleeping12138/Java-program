package Demo1;


public class MyBtree {

    static class BTRNode {
        public int[] keys;//关键字
        public BTRNode[] subs;//孩子
        public BTRNode parent;//存储当前孩子节点的父亲节点
        public int usedSize;//记录当前节点中关键字的数量

        public BTRNode () {
            //这里多给一个 是为了好进行分裂
            this.keys = new int[M];
            this.subs = new BTRNode[M+1];
        }
    }

    public static final int M = 3;
    public BTRNode root;//当前B树的根节点

    /**
     * 往B树当中 插入一个元素
     * @param key
     */
    public boolean insert(int key) {
        //1、如果B树为空的时候
        if(root == null) {
            root = new BTRNode();
            root.keys[0] = key;
            root.usedSize++;
            return true;
        }

        //2、当B树不为空的时候，我们需要查看当前B树当中 是否存在我的Key
        Pair<BTRNode,Integer> pair = find(key);
        //判断 这里获取到的val值 是不是-1   来确定 当前是否存在该key
        if(pair.getVal() != -1) {
            return false;
        }

        //3、说明不存在这个key 我们要进行插入
        BTRNode parent = pair.getKey();
        int index = parent.usedSize-1;
        for (; index >= 0;index--) {
            if(parent.keys[index] >= key) {
                parent.keys[index+1] = parent.keys[index];
            }else {
                break;
            }
        }
        parent.keys[index+1] = key;
        parent.usedSize++;
        //为什么不处理 孩子呢  因为你每次插入都是再叶子节点，所以叶子节点都是null
        if(parent.usedSize < M) {
            //没有满
            return true;
        }else {
            //满了-》分裂
            split(parent);
            return true;
        }
    }

    /**
     * 分裂的逻辑
     * @param cur 当前需要分裂的节点
     */
    private void split(BTRNode cur) {
        BTRNode newNode = new BTRNode();
        //1. 先存储当前需要分裂节点的父节点
        BTRNode parent = cur.parent;
        //2. 开始挪数据
        int mid = cur.usedSize >> 1;
        int i = mid+1;
        int j = 0;
        for( ; i < cur.usedSize;i++) {
            newNode.keys[j] = cur.keys[i];
            newNode.subs[j] = cur.subs[i];
            //处理刚刚拷贝过来的孩子节点的父亲节点 为新分裂的节点
            if(newNode.subs[j]!=null) {
                newNode.subs[j].parent = newNode;
            }
            j++;
        }
        //多拷贝一次孩子
        newNode.subs[j] = cur.subs[i];
        if(newNode.subs[j]!=null) {
            newNode.subs[j].parent = newNode;
        }
        //更新当前新节点的有效数据
        newNode.usedSize = j;
        //这里的-1 指的是  将来要提到父亲节点的key
        cur.usedSize = cur.usedSize - j - 1;

        //特殊：处理根节点的情况
        if(cur == root) {
            root = new BTRNode();
            root.keys[0] = cur.keys[mid];
            root.subs[0] = cur;
            root.subs[1] = newNode;
            root.usedSize = 1;
            cur.parent = root;
            newNode.parent = root;
            return;
        }

        //更新当前新的节点的父亲节点
        newNode.parent = parent;

        //开始移动父亲节点
        int endT = parent.usedSize-1;
        int midVal = cur.keys[mid];
        for (; endT >= 0 ; endT--) {
            if(parent.keys[endT] >= midVal) {
                parent.keys[endT+1] = parent.keys[endT];
                parent.subs[endT+2] = parent.subs[endT+1];
            }else {
                break;
            }
        }
        parent.keys[endT+1] = midVal;
        //将当前父节点的孩子节点 新增为newNode
        parent.subs[endT+2] = newNode;
        parent.usedSize++;

        if(parent.usedSize >= M) {
            split(parent);
        }
    }

    private Pair<BTRNode,Integer> find(int key) {
        BTRNode cur = root;
        BTRNode parent = null;
        while (cur != null) {
            int i = 0;
            while (i < cur.usedSize) {
                if(cur.keys[i] == key) {
                    //返回一个当前找到的节点 和 当前这个数据在节点当中的下标
                    return new Pair<>(cur,i);
                }else if(cur.keys[i] < key) {
                    i++;
                }else {
                    break;
                }
            }
            parent = cur;
            cur = cur.subs[i];
        }
        return new Pair<>(parent,-1);
    }


    public static void main(String[] args) {
        MyBtree myBtree = new MyBtree();
        int[] array = {53, 139, 75, 49, 145, 36,101};
        for (int i = 0; i < array.length; i++) {
            myBtree.insert(array[i]);
        }
        System.out.println("fdsafafa");
        myBtree.inorder(myBtree.root);
    }

    private void inorder(BTRNode root){
        if(root == null)
            return;
        for(int i = 0; i < root.usedSize; ++i){
            inorder(root.subs[i]);
            System.out.println(root.keys[i]);
        }
        inorder(root.subs[root.usedSize]);
    }
}
