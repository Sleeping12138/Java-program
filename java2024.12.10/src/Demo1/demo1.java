package Demo1;

import java.util.TreeMap;

class demo1 {
    // 使用TreeMap解决
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length,left = 0,maxLen = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int right = 0;right<n;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.lastKey()-map.firstKey()>limit){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }

        return maxLen;
    }
}
