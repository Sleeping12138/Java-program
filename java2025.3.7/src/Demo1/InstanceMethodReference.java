package Demo1;

import java.util.function.Supplier;

public class InstanceMethodReference {
    public static void main(String[] args) {
        InstanceMethodReference instance = new InstanceMethodReference();

        // 使用Lambda表达式
        Supplier<String> lambdaSupplier = () -> instance.getMessage();

        // 使用方法引用
        Supplier<String> methodReferenceSupplier = instance::getMessage;

        System.out.println(lambdaSupplier.get());  // 输出：Hello, Method Reference!
        System.out.println(methodReferenceSupplier.get());  // 输出：Hello, Method Reference!
    }

    public String getMessage() {
        return "Hello, Method Reference!";
    }
}

