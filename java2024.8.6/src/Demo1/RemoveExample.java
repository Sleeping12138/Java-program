package Demo1;

import java.util.HashSet;
import java.util.Set;

public class RemoveExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");

        boolean removed = set.remove("Banana");
        boolean notRemoved = set.remove("Cherry");

        System.out.println(set);
        System.out.println(removed);
        System.out.println(notRemoved);
    }
}
