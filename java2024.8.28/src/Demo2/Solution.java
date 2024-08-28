package Demo2;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
    public int number;
    public int line;

    public Pair(int number, int line) {
        this.number = number;
        this.line = line;
    }
}
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ability = new int[mat.length];
        calAbility(mat,ability);
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.number!=o2.number){
                    return o1.number- o2.number;
                }else{
                    return o1.line-o2.line;
                }
            }
        });

        for (int i = 0; i < ability.length; i++) {
            priorityQueue.offer(new Pair(ability[i],i));
        }

        int[] ret = new int[k];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = priorityQueue.poll().line;
        }
        return ret;
    }
    public void calAbility(int[][] mat,int[] ability){
        int index = 0;
        for (int i = 0;i<mat.length;i++){
            int sum = 0;
            for(int j = 0;j<mat[i].length;j++){
                if(mat[i][j]!=0){
                    sum++;
                }else{
                    break;
                }
            }
            ability[index++] =sum;
        }
    }
}
