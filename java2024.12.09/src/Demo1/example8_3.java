
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class example8_3 {
    public static void main(String[] args) {

        if (args.length != 6) {
            System.out.println("请提供两个日期（年 月 日 年 月 日），共6个参数");
            return;
        }
        try {
            int startYear = Integer.parseInt(args[0]);
            int startMonth = Integer.parseInt(args[1]);
            int startDay = Integer.parseInt(args[2]);
            LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);

            // 解析结束日期
            int endYear = Integer.parseInt(args[3]);
            int endMonth = Integer.parseInt(args[4]);
            int endDay = Integer.parseInt(args[5]);
            LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

            if (startDate.isAfter(endDate)) {
                System.out.println("起始日期不能晚于结束日期。");
                return;
            }

            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
            System.out.println("从 " + startDate + " 到 " + endDate + " 之间共有 " + daysBetween + " 天。");

        } catch (NumberFormatException e) {
            System.out.println("无效的日期格式，请确保输入的是有效的整数。");
        } catch (Exception e) {
            System.out.println("日期解析失败，请检查输入的日期是否有效。");
        }
    }
}