import java.util.HashSet;
import java.util.Set;

public class IsEmptyExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        boolean isEmptyBeforeAdd = set.isEmpty();
        set.add("Apple");
        boolean isEmptyAfterAdd = set.isEmpty();

        System.out.println(isEmptyBeforeAdd);
        System.out.println(isEmptyAfterAdd);
    }
}