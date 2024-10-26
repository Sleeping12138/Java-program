package Demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class demo2 {
    public static void main(String[] args) {
//        new Callable<>()
        CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>();
        ConcurrentHashMap<String, Integer> stringIntegerConcurrentHashMap = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

    }
}
