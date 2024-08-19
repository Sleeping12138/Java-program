package Demo2;

//KMP算法
public class StringKMP {
    public int KMP(String str, String sub, int pos) {
        if (str == null || sub == null) {
            return -1;
        }
        int lenStr = str.length();
        int lenSub = sub.length();
        if (lenSub == 0 || lenStr == 0) {
            return -1;
        }

        int i = pos;
        int j = 0;

        int[] next = new int[lenSub];
        getNext(sub, next);

        while (i < lenStr && j < lenSub) {
            if (str.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
                if (j == -1) {
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

    private void getNext(String sub, int[] next) {
        next[0] = -1;
        int i = 1;
        int k = -1;
        while (i < sub.length()) {
            if (k == -1 || sub.charAt(i - 1) == sub.charAt(k)) {
                next[i] = sub.charAt(i) == sub.charAt(k + 1) ? next[k + 1] : k + 1;
                k++;
                i++;
            } else {
                k = next[k];
            }
        }
    }
}
