package Demo1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class demo9 {
    public static void main(String[] args) {
//        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(new Comparator<Double>() {
//            @Override
//            public int compare(Double o1, Double o2) {
//                return (int)(o2-o1);
//            }
//        });


        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(new Comparator<Double>(){
            public int compare(Double o1,Double o2){
                return Double.compare(o1,o2);
            }
        });

    }
}
