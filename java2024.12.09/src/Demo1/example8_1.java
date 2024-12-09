public class example8_1{

    public static void main(String[] args) {
        String originalString = "Hello, World!";
        System.out.println("原始字符串: " + originalString);
        String upperCaseString = originalString.toUpperCase();
        System.out.println("转换为大写后的字符串: " + upperCaseString);


        String lowerCaseString = originalString.toLowerCase();
        System.out.println("转换为小写后的字符串: " + lowerCaseString);

        String secondString = " How are you?";
        String concatenatedString = originalString.concat(secondString);
        System.out.println("连接后的字符串: " + concatenatedString);

        String combinedString = originalString.toUpperCase().toLowerCase().concat("Java");
        System.out.println("综合练习结果: " + combinedString);
    }
}
