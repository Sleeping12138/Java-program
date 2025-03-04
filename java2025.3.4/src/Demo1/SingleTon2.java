package Demo1;

public class SingleTon2 {
    private SingleTon2() {
    }

    private static SingleTon2 singleTon2;

    static {
        singleTon2 = new SingleTon2();
    }

    public static SingleTon2 getInstance() {
        return singleTon2;
    }
}
