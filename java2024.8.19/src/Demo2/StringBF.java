package Demo2;

//暴力算法
public class StringBF {
    public int BF(String str, String sub) {
        if (str == null || sub == null) {
            return -1;
        }
        int lenStr = str.length();
        int lenSub = sub.length();
        if (lenSub == 0 || lenStr == 0) {
            return -1;
        }

        int i = 0;
        int j = 0;
        while (i < lenStr && j < lenSub) {
            if (str.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j >= lenSub) {
            return i - j;
        }
        return -1;
    }
}
