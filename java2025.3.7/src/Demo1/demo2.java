package Demo1;
import java.util.function.Function;

public class demo2 {

    class StaticMethodReference {
        public static void main(String[] args) {
            // 使用Lambda表达式
            Function<Integer, String> lambdaFunction = (num) -> StaticMethodReference.convertToString(num);

            // 使用方法引用
            Function<Integer, String> methodReferenceFunction = StaticMethodReference::convertToString;

            System.out.println(lambdaFunction.apply(100));  // 输出：100
            System.out.println(methodReferenceFunction.apply(200));  // 输出：200
        }

        public static String convertToString(int num) {
            return String.valueOf(num);
        }
    }

}
