package Demo2;

import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ContainsAllExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        List<String> list = Arrays.asList("Apple", "Banana");

        boolean containsAll = set.containsAll(list);
        System.out.println(containsAll);
    }
}
