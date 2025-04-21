package Demo;

import java.util.Scanner;



public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int ret = switch (number){
            case 1 -> 1;
            case 2 ->2;
            default -> 0;
        };
        System.out.println(ret);
        String grade = "a";

        String result = switch (grade) {
            case "A" -> "优秀";
            case "B" -> {
                System.out.println("处理 B 等级");
                yield "良好";  // 多行时，必须用 yield 返回值
            }
            default -> {
                System.out.println("未知等级");
                yield "不及格";
            }
        };

    }
}
