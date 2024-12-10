package Demo1;

class Node3{
    Node3[] son = new Node3[26];
    boolean end;
}
class WordDictionary {
    public Node3 root;

    public WordDictionary() {
        root = new Node3();
    }

    public void addWord(String word) {
        Node3 cur = root;
        for(char ch : word.toCharArray()){
            int index = ch-'a';
            if(cur.son[index]==null) cur.son[index] = new Node3();
            cur = cur.son[index];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(root, word);
    }

    public boolean dfs(Node3 Node3, String str) {
        if (str.isEmpty()) {
            return Node3.end;
        }

        char ch = str.charAt(0);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (Node3.son[i] != null && dfs(Node3.son[i], str.substring(1))) {
                    return true;
                }
            }
            return false;
        } else {
            int index = ch - 'a';
            if (Node3.son[index] == null) {
                return false;
            }
            return dfs(Node3.son[index], str.substring(1));
        }
    }

}

