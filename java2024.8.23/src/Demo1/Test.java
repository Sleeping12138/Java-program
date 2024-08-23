package Demo1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
//        HashMap<String, Integer> map = new HashMap<>();
//        HashSet<Integer> set = new HashSet<>();
//        Iterator<Integer> iterator = set.iterator();

        //
        String str = new String("hello");
        str.intern();
        String str1 = "hello";
        System.out.println(str == str1);

//        char[] chs = {'a', 'b', 'c'};
//        String str1 = new String(chs);
//        str1.intern();
//        String str2 = "abc";
//        System.out.println(str1 == str2);


    }
}
