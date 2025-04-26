package Demo;

public class code3 {
    public static void main(String[] args) {

    }

    int n, index;

    public String decodeString(String s) {
        char[] chs = s.toCharArray();
        n = chs.length;
        return dfs(chs);
    }

    public String dfs(char[] chs) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (index < n) {
            if (Character.isDigit(chs[index])) {
                num = num * 10 + (chs[index] - '0');
            } else if (chs[index] == '[') {
                index++;
                String s = dfs(chs);
                for (int i = 0; i < num; i++) {
                    sb.append(s);
                }
                num = 0;
            } else if (chs[index] == ']') {
                return sb.toString();
            } else {
                sb.append(chs[index]);
            }
            index++;
        }
        return sb.toString();
    }
}
