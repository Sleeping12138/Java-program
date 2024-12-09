import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class example8_6_3 {

    public static void main(String[] args) {
        String input = "数学87分,物理76分,英语96分";

        Pattern pattern = Pattern.compile("(\\D+)(\\d+)分");
        Matcher matcher = pattern.matcher(input);

        int totalScore = 0;
        int count = 0;

        while (matcher.find()) {
            String subject = matcher.group(1).trim();
            int score = Integer.parseInt(matcher.group(2));

            totalScore += score;
            count++;
        }
        if (count == 0) {
            System.out.println("输入格式错误：未找到有效的分数。");
            return;
        }

        double averageScore = (double) totalScore / count;

        System.out.println("总成绩: " + totalScore);
        System.out.printf("平均分数: %.2f\n", averageScore);
    }
}