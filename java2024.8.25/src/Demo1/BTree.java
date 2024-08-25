package Demo1;

//B树的自我实现
public class BTree {

    //节点的定义
    public static class BTreeNode {
        public int[] keys;
        public BTreeNode[] subs;
        public BTreeNode parent;
        int usedSize;

        public BTreeNode() {
            keys = new int[M];
            subs = new BTreeNode[M + 1];
        }
    }

    public BTreeNode root;
    public static final int M = 3;

    public BTree() {

    }

    /**
     * （1）判断根节点是否为空
     * （2）找到合适的节点进行插入
     * （3）判断是否需要进行分裂
     * @param val
     * @return
     */
    public boolean insert(int val) {
        //判断根节点是否是空
        if (root == null) {
            root = new BTreeNode();
            root.keys[0] = val;
            root.usedSize++;
            return true;
        }

        //根节点不为空,查找树中是否已经存在了
        BTreeNode ret = find(val);
        if (ret == null) {
            return false;
        }

        //在树中不存在元素，要进行插入元素
        int index = ret.usedSize - 1;
        for (; index >= 0; index--) {
            if (ret.keys[index] >= val) {
                ret.keys[index + 1] = ret.keys[index];
            } else {
                break;
            }
        }
        ret.keys[index + 1] = val;
        ret.usedSize++;

        //判断是否需要进行分裂
        if (ret.usedSize >= M) {
            split(ret);
            return true;
        } else {
            return true;
        }
    }

    private void split(BTreeNode cur) {
        BTreeNode newNode = new BTreeNode();
        BTreeNode parent = cur.parent;
        int middle = cur.usedSize / 2;
        int i = middle + 1;
        int j = 0;

        for (; i < cur.usedSize; i++) {
            newNode.keys[j] = cur.keys[i];
            newNode.subs[j] = cur.subs[i];
            if (newNode.subs[j] != null) {
                newNode.subs[j].parent = newNode;
            }
            j++;
        }
        newNode.subs[j] = cur.subs[i];
        if (newNode.subs[j] != null) {
            newNode.subs[j].parent = newNode;
        }

        newNode.usedSize = j;
        cur.usedSize = cur.usedSize - j - 1;

        //如果是根节点进行分裂
        if (cur == root) {
            BTreeNode newBNode = new BTreeNode();
            root = newBNode;
            newBNode.keys[0] = cur.keys[middle];
            newBNode.subs[0] = cur;
            cur.parent = root;
            newBNode.subs[1] = newNode;
            newNode.parent = root;
            root.usedSize++;
            return;
        }

        //如果不是根节点进行分裂
        newNode.parent = parent;
        int num = cur.keys[middle];
        int end = parent.usedSize - 1;
        for (; end >= 0; end--) {
            if (parent.keys[end] >= num) {
                parent.keys[end + 1] = parent.keys[end];
                parent.subs[end + 2] = parent.subs[end + 1];
            } else {
                break;
            }
        }
        parent.keys[end + 1] = num;
        parent.subs[end + 2] = newNode;
        parent.usedSize++;

        if (parent.usedSize >= M) {
            split(parent);
        }
    }

    private BTreeNode find(int val) {
        BTreeNode parent = null;
        BTreeNode cur = root;
        while (cur != null) {
            int i = 0;
            for (; i < cur.usedSize; i++) {
                if (cur.keys[i] == val) {
                    //可能会导致分歧
                    return null;
                } else if (cur.keys[i] > val) {
                    break;
                }
            }
            parent = cur;
            cur = cur.subs[i];
        }
        return parent;
    }

    public void inorder(BTreeNode root){
        if (root == null) {
            return;
        }
        inorder(root.subs[0]);
        for (int i = 0; i < root.usedSize; i++) {
            System.out.print(root.keys[i]+" ");
            inorder(root.subs[i + 1]);
        }
    }
}

