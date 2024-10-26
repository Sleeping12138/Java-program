package Demo1;

public class demo1 {
    public static void main(String[] args) {
        int[] array = {7, 2, 7, 9, 8, 1, 1, 2, 9, 9, 6, 9, 9};
        int maxval = array[0], count = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == maxval) count++;
            else if (array[i] > maxval) {
                maxval = array[i];
                count = 1;
            }
        }
        System.out.println(maxval + " -> " + count);
    }
}
