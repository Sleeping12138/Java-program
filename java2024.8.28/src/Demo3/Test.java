package Demo3;

public class Test {
    public static void main(String[] args) {
        //字符转换为数字
        /**
         * 直接减去'0'
         * 使用getNumericValue
         * 如果为英文字符，直接进行强制转换
         */

//        char ch = '9';
//        System.out.println(ch - '0'+1);
//        System.out.println(Character.getNumericValue(ch)+10);
//
//        //如果为英文字符，直接进行强制转换
//        char ch2 = 'z';
//        System.out.println(ch2);
//        System.out.println((int)ch2);
//
//        //数字转换为字符
//        int num = 9;
//        System.out.println((char)(num+'0'));
//        System.out.println(Character.forDigit(num,10));

//        String str = "1010";
//        System.out.println(Integer.parseInt(str,2));

        int num = 10;
        System.out.println(Integer.toBinaryString(num)+1);

    }
}
