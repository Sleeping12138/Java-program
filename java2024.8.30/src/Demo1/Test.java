package Demo1;

public class Test {
    public static void main(String[] args) {
        int left = 0,right = 10;
    }
    public static boolean repeatedSubstringPattern(String s) {
        int lenMax = s.length() / 2;
        for (int i = 0; i < lenMax; i++) {
            if (s.length() % (i + 1) == 0) { // 只有当 s 的长度能被 i+1 整除时，才可能由该子串组成
                String str = s.substring(0, i + 1);
                StringBuilder sb = new StringBuilder();
                int count = s.length() / (i + 1);
                while (count != 0) {
                    sb.append(str);
                    count--;
                }
                if (s.equals(sb.toString()))
                    return true;
            }
        }
        return false;
    }
}
