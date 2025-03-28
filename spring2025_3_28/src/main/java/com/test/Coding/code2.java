package com.test.Coding;

public class code2 {
    public int n;
    public int rob(int[] nums) {
        n = nums.length;
        if(n==1) return nums[0];
        return Math.max(maxMoney(nums,0,n-1),maxMoney(nums,1,n));
    }
    public int maxMoney(int[] nums,int left,int right){
        int[] f = new int[n];
        int[] g = new int[n];

        f[left] = nums[left];

        for(int i = left+1;i<right;i++){
            f[i] = g[i-1]+nums[i];
            g[i] = Math.max(f[i-1],g[i-1]);
        }

        return Math.max(f[right-1],g[right-1]);
    }
}
