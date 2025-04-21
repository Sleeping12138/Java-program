package Demo;

import java.util.Arrays;
import java.util.Comparator;

public class code4 {
    public static void main(String[] args) {
        Integer[] array = {2, 4, 1, 5, 3};
        Arrays.sort(array, (o1, o2) -> o2 - o1);
    }
}
