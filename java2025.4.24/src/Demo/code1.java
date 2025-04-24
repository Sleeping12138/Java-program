package Demo;

import java.util.ArrayDeque;
import java.util.Deque;

public class code {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        Deque<String> strDeque = new ArrayDeque<>();
        Deque<Integer> intDeque = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                intDeque.offerLast(n);
                n = 0;
                strDeque.offerLast(sb.toString());
                sb = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder();
                int num = intDeque.pollLast();
                for (int i = 0; i < num; i++) temp.append(sb.toString());
                sb = new StringBuilder(strDeque.pollLast() + temp.toString());
            } else if (Character.isDigit(ch)) {
                n = n * 10 + Integer.parseInt(ch + "");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
