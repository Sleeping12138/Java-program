public class Test {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        if(nums.length == 1){
            System.out.println(1);
        }
        int number = 0;
        int dest = 0;
        int cur = 1;

        while(cur<nums.length){
            if(nums[cur]!=nums[dest]){
                nums[++dest] = nums[cur];
                number++;
            }
            cur++;
        }

        System.out.println(number);
    }
}
