import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            brokenWords(a, b);
        }
    }
    public static void brokenWords(String str1, String str2) {
        String str1Big = str1.toUpperCase();
        String str2Big = str2.toUpperCase();

        HashSet<Character> hashSet = new HashSet<>();

        for (int i = 0; i < str1Big.length(); i++) {
            hashSet.add(str1Big.charAt(i));
        }
        for(int i = 0;i<str2Big.length();i++){
            hashSet.remove(str2Big.charAt(i));
        }

        Iterator<Character> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }
}