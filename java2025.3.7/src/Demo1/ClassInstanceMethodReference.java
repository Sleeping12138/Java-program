package Demo1;

import java.util.function.BiPredicate;

public class ClassInstanceMethodReference {

    public static void main(String[] args) {
        // 使用Lambda表达式
        BiPredicate<String, String> lambdaPredicate = (a, b) -> a.equals(b);

        // 使用方法引用
        BiPredicate<String, String> methodReferencePredicate = String::equals;

        System.out.println(lambdaPredicate.test("Hello", "Hello"));  // 输出：true
        System.out.println(methodReferencePredicate.test("Hello", "World"));  // 输出：false
    }
}

