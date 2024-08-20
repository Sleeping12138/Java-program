package Demo2;

import java.util.Comparator;

public class LessIntComp implements Comparator<Integer> {
    //默认为小根堆
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
