package Demo1;

// 每个节点都是一个26个大小的数组
class Node {
    Node[] son = new Node[26];
    boolean end;
}

class Trie {
    public Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.son[index] == null) cur.son[index] = new Node();
            cur = cur.son[index];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return find(word) == 2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    public int find(String str) {
        Node cur = root;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (cur.son[index] == null) return 0;
            cur = cur.son[index];
        }
        return cur.end == true ? 2 : 1;
    }
}

public class demo3 {


}
