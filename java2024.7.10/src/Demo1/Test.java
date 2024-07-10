package Demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {


    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> arrayList = new ArrayList<>();
            for (int k = 0; k <= i; k++) {
                if (k == 0 || k == i) {
                    arrayList.add(1);
                } else {
                    int temp = arrayLists.get(i - 1).get(k) + arrayLists.get(i - 1).get(k - 1);
                    arrayList.add(temp);
                }
            }
            arrayLists.add(arrayList);
        }
        return arrayLists;
    }
}
