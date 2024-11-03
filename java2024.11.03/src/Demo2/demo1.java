package Demo2;

public class demo1 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    public static String compressString(String param) {
        char[] chs = param.toCharArray();
        int left = 0, right = 0, count = 0;
        StringBuilder sb = new StringBuilder();
        while (right < chs.length) {
            if (chs[left] == chs[right]) {
                right++;
                count++;
            } else {
                sb.append(chs[left]);
                left = right;
                if (count > 1) sb.append(count);
                count = 0;
            }
        }
        sb.append(chs[left]);
        if (count > 1) sb.append(count);
        return sb.toString();
    }
}
