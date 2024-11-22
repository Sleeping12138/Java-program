package Demo1;

import java.util.ArrayList;
import java.util.Scanner;

public class demo3 {
    // 前i组内的背包，容量为j的情况下，能装下的最大价值
    static int[][] memo;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int V = input.nextInt();
        memo = new int[N+1][V+1];

        ArrayList<Integer>[] volume = new ArrayList[N];
        ArrayList<Integer>[] weight = new ArrayList[N];
        for (int i = 0; i < N; i++){
            int s = input.nextInt();
            ArrayList<Integer> groupVolume = new ArrayList<>();
            ArrayList<Integer> groupWeight = new ArrayList<>();
            for (int j=0; j<s; j++){
                groupVolume.add(input.nextInt());
                groupWeight.add(input.nextInt());
            }
            volume[i] = groupVolume;
            weight[i] = groupWeight;
        }

        int maxVal = dp(V, volume, weight);
        System.out.println(maxVal);
    }

    static int dp(int v, ArrayList<Integer>[] volume, ArrayList<Integer>[] weight){
        for (int i=1; i<=volume.length; i++){
            for (int j=1; j<=v; j++){
                // 对于每个组，可能选择其中一个物品，也可能一个物品都不选
                for (int k=0; k<volume[i-1].size(); k++){
                    if (j - volume[i-1].get(k) >= 0){
                        memo[i][j] = Math.max(memo[i][j], memo[i-1][j - volume[i-1].get(k)] + weight[i-1].get(k));
                    }
                }
                // 由于每组只能取一个，最大值需要重新判断
                memo[i][j] = Math.max(memo[i-1][j], memo[i][j]);
            }
        }
        // todo
        return memo[volume.length][v];
    }
}

