import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("hello");
//        arrayList.add("the");
//        arrayList.add("world");
//
//        String[] array = arrayList.toArray(new String[10]);
//        System.out.println(Arrays.toString(array));

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        int[] array = set.toArray(new Integer[0]);
    }

//    public boolean findTarget(TreeNode root, int k) {
//        HashSet<Integer> set = new HashSet<>();
//        getSetArray(root,set);
//        Integer[] array = set.toArray(new Integer[0]);
//
//        int left = 0;
//        int right = array.length - 1;
//        while(left<right){
//            if(array[left]+array[right]>k){
//                right--;
//            }else if(array[left]+array[right]<k){
//                left++;
//            }else{
//                return true;
//            }
//
//        }
//        return false;
//    }
//    public void getSetArray(TreeNode root,HashSet<Integer> set){
//        if(root==null) return;
//        getSetArray(root.left,set);
//        set.add(root.val);
//        getSetArray(root.right,set);
//    }

}
