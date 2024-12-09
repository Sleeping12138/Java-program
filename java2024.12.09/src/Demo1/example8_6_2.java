import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class example8_6_2 {

    public static void main(String[] args) {
        String input = "数学87分,物理76分,英语96分";

        try (Scanner scanner = new Scanner(input)) {
            scanner.useDelimiter("[分,\\s]*");

            int totalScore = 0;
            int count = 0;

            while (scanner.hasNext()) {
                String token = scanner.next().trim();

                if (!token.isEmpty()) {
                    try {
                        int score = Integer.parseInt(token);
                        totalScore += score;
                        count++;
                    } catch (NumberFormatException e) {
                    }
                }
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
}
