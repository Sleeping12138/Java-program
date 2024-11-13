package Demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// 多线程中使用ArrayList
public class demo7 {
    public static void main(String[] args) {
        // 手动添加synchronized
        List<Integer> objects = Collections.synchronizedList(new ArrayList<Integer>());
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    }
}
