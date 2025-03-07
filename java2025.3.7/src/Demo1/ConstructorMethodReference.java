package Demo1;

import java.util.function.Supplier;

class User {
    public User() {
        System.out.println("User 对象被创建！");
    }
}

public class ConstructorMethodReference {
    public static void main(String[] args) {
        // 使用Lambda表达式
        Supplier<User> lambdaSupplier = () -> new User();

        // 使用构造方法引用
        Supplier<User> methodReferenceSupplier = User::new;

        lambdaSupplier.get();  // 输出：User 对象被创建！
        methodReferenceSupplier.get();  // 输出：User 对象被创建！
    }
}

