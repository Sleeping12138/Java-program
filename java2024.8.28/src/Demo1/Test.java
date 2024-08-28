package Demo1;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder("123");
//        System.out.println(stringBuilder.toString());
//        System.out.println(stringBuilder.charAt(1));
//        System.out.println(Integer.parseInt());
//        Character.getNumericValue()
//
//        String str = "1101";
//        String a = "11";
//        String b = "1";
//        System.out.println(addBinary(a,b));

//        System.out.println((char)(9 + '0'));

        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern,s));
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        String[] strs = s.split(" ");
        int index = 0;
        for(char ch:pattern.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch,strs[index++]);
            }else{
                if(map.get(ch)!=strs[index++]){
                    return false;
                }
            }
        }
        return true;
    }
    public static String addBinary(String a, String b) {
        // 将二进制字符串转换为整数
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);

        // 将相加的结果转换为二进制字符串
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num1 + num2));

        // 处理进位问题
        for (int len = sb.length() - 1; len > 0; len--) {
            char ch = sb.charAt(len);
            if (ch >= '2') {  // 这里的 '2' 应该改为字符 '2' 的值减去 '0'
                // 当前位处理
                sb.setCharAt(len, (char)((ch - '0') % 2 + '0'));
                // 前一位进位处理
                sb.setCharAt(len - 1, (char)(sb.charAt(len - 1) + 1));
            }
        }

        // 检查最高位是否需要进位
        if (sb.charAt(0) >= '2') {
            sb.setCharAt(0, (char)((sb.charAt(0) - '0') % 2 + '0'));
            sb.insert(0, '1');
        }

        return sb.toString();
    }
}
