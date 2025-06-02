package com.ojtest.demo;

import java.util.*;

class code3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) map.put(i, new ArrayList<>());

        for (int[] num : prerequisites) {
            int a = num[1], b = num[0];
            map.get(a).add(b);
            in[b]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int node : map.get(n)) {
                in[node]--;
                if (in[node] == 0)
                    queue.offer(node);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0)
                return false;
        }
        return true;
    }
}
