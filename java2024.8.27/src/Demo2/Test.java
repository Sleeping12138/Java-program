package Demo2;

public class Test {
//    public static void main(String[] args) {
    //字符串的大小写转换
//        String str = "Hello World";
//        System.out.println(str.toLowerCase());
//        System.out.println(str.toUpperCase());


    //字符串的创建方式
//        String str1 = "hello world";
//        String str2 = new String("hello world");
//
//        char[] chs = {'a','b','c','d'};
//        System.out.println(new String(chs));
//
//        byte[] bytes = {97,98,99,100};
//        System.out.println(new String(bytes));

    //将字符串转变为字符数组 + 字节数组
//        String str = "hello world";
//        for (int i = 0; i < str.length(); i++) {
//            System.out.print(str.charAt(i) + " ");
//        }
//        System.out.println();
//        for (char ch : str.toCharArray()) {
//            System.out.print(ch + " ");
//        }
//        System.out.println();
//        for (byte b : str.getBytes()) {
//            System.out.print(b + " ");
//        }


    //字符串比较大小
//        String str1 = "hello";
//        String str2 = "Hello";
//        System.out.println(str1 == str2);
//        System.out.println(str1.equals(str2));
//        System.out.println(str1.compareTo(str2));

//        String str = "hello world";
//        for (int i = 0; i < str.length(); i++) {
//            System.out.print(str.charAt(i)+" ");
//        }
//
//        System.out.println(str.isEmpty());

    //contains是用来判断是否存在子字符串的
    //indexOf是用来判断是否存在某个字符的
//        System.out.println(str.contains("ell"));
//        System.out.println(str.indexOf('e'));


//        String str = "hello world";
//        System.out.println(str.startsWith("hel"));
//        System.out.println(str.endsWith("lld"));

//        int num = 100;
//        System.out.println(num + 1);
//        System.out.println(String.valueOf(num)+1);


//        String name = "coco";
//        int age = 18;
//        String str = String.format("name:%s age:%d", name, age);
//        System.out.println(str);

//        String str = "coco is coco a coco";
////        String s = str.replaceAll("cooc", "xxx");
////        System.out.println(s);
//        String s = str.replaceAll("c|o", "X");
//        System.out.println(s);

    //使用subString方法截取子串
//        String str = "hello world";
//        System.out.println(str.substring(7,8));

    //trim - 取出头尾的空格
//        String str = "  hello world  ";
//        System.out.println(str);
//        String trim = str.trim();
//        System.out.println(trim);
//    }
    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("hello");
//        stringBuilder.append(" world");
//        System.out.println(stringBuilder.toString());
//        stringBuilder.replace(0,6,"");
//        System.out.println(stringBuilder.toString());

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("hello");
//        stringBuilder.insert(2,"xxx");
//        System.out.println(stringBuilder.toString());
//        int index = stringBuilder.indexOf("l");
//        System.out.println(index);

        //使用StringBuilder可以实现目标字符的增删改查
        /**
         * 增 ；insert
         * 删 ：deleteCharAt
         * 改 ：setCharAt
         * 查 ：charAt
         */
    }
}
