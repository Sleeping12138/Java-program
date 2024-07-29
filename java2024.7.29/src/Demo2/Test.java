package Demo2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        list.sort(new Comparator<String>() {
            public int compare(String word1,String word2){
                return map.get(word1) == map.get(word2) ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
            }
        });
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}
