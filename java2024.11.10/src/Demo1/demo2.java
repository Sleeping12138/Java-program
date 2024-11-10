package Demo1;

public class demo2 {
    private String instanceVariable = "Hello from outer class";

    public void execute() {
        String localVar = "Hello from lambda";

        Runnable r = () -> {
            System.out.println(this.instanceVariable); // 访问外部类的实例变量 Hello from outer class
            System.out.println(localVar);              // 访问外部方法的局部变量 Hello from lambda
        };

        r.run();
    }

    public static void main(String[] args) {
        new demo2().execute();
    }
}
