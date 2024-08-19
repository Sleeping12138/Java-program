package Demo1;

public class Test {
    public static void main(String[] args) {
        System.out.println(KMP("ababcabcdabcdeabcdef","abcd",0));

        System.out.println(KMP("a","a",0));
    }

    public static int KMP(String str, String sub, int pos) {
        if (str == null || sub == null) return -1;
        int lenStr = str.length();
        int lenSub = sub.length();
        if (lenSub == 0 || lenStr == 0) return -1;

        int i = pos; //遍历母串
        int j = 0; //遍历子串

        int[] next = new int[lenSub];
        getNext(sub, next);

        while (i < lenStr && j < lenSub) {
            if (str.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];

                //从下一个字符开始遍历
                if(j==-1){
                    j = 0;
                    i++;
                }
            }
        }

        if (j >= lenSub) {
            return i - j;
        }
        return -1;
    }

    private static void getNext(String sub, int[] next) {
        next[0] = -1;
        int index = 1;
        int k = -1;

        while (index < sub.length()) {
            if (k == -1 || sub.charAt(index - 1) == sub.charAt(k)) {
                next[index] = sub.charAt(index) == sub.charAt(k + 1) ? next[k + 1] : k + 1;
                k++;
                index++;
            } else {
                k = next[k];
            }
        }
    }

}
