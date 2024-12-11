package Demo1;

import java.util.List;

// 创建字典树数据结构
class Node {
    Node[] son = new Node[26];
    boolean end;
}

class Trie {
    public Node root;

    public Trie() {
        root = new Node();
    }

    public void addString(String str) {
        Node cur = root;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (cur.son[index] == null) cur.son[index] = new Node();
            cur = cur.son[index];
        }
        cur.end = true;
    }

    public int searchFront(String str) {
        Node cur = root;
        int i = 0;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (cur.end == true) return i;
            if (cur.son[index] == null) return -1;
            i++;
            cur = cur.son[index];
        }
        return cur.end == true ? i : -1;
    }
}

class Solution {
    public static void main(String[] args) {

    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie tree = new Trie();
        for (String str : dictionary) tree.addString(str);
        String[] strs = sentence.split(" ");
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            int ret = tree.searchFront(strs[i]);
            if (ret != -1) strs[i] = strs[i].substring(0, ret);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(strs[i]);
            if (i != n - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
