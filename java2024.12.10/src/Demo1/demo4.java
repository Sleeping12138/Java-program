package Demo1;

import java.util.HashMap;

class Node2{
    public HashMap<Character,Node2> map = new HashMap<>();
    public boolean end;
}
class Trie2 {
    public Node2 root;

    public Trie2() {
        this.root = new Node2();
    }

    public void insert(String word) {
        Node2 cur = root;
        for(char ch : word.toCharArray()){
            if(!cur.map.containsKey(ch)) cur.map.put(ch,new Node2());
            cur = cur.map.get(ch);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return find(word)==2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix)!=0;
    }

    public int find(String str){
        Node2 cur = root;
        for(char ch : str.toCharArray()){
            if(!cur.map.containsKey(ch)) return 0;
            cur = cur.map.get(ch);
        }
        return cur.end==true?2:1;
    }
}

public class demo4 {
}
