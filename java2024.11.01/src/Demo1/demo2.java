package Demo1;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            String str = String.valueOf(in.nextInt());
            char[] chs = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char ch : chs){
                String temp = NumberType(ch-'0');
                sb.append(temp);
            }

//            sb = sb.reverse();
            for(int i = 0;i<sb.length();i++){
                if(sb.charAt(i)=='0') {
                    sb.deleteCharAt(i);
                    i--;
                }
                else break;
            }

            String ret = sb.toString();
            if (ret.equals("")) System.out.println("0");
            else{
                System.out.println(ret);
            }
        }
    }

    public static String NumberType(int number){
        return number%2==0?"0":"1";
    }
}
