public class example8_5 {

    public static void main(String[] args) {
        String input = "ab123you";
        String result = removeNonDigits(input);
        System.out.println("原始字符串: " + input);
        System.out.println("去除非数字字符后的字符串: " + result);
    }

    public static String removeNonDigits(String str) {
        return str.replaceAll("\\D", "");
    }
}