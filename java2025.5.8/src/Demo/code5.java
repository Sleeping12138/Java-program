package Demo;

// 懒汉单例
class SingleTon2 {
    private SingleTon2() {
    }

    private volatile static SingleTon2 singleTon2 = null;

    private static final Object lock = new Object();

    public static SingleTon2 getSingleTon2() {
        if (singleTon2 == null) {
            synchronized (lock) {
                if (singleTon2 == null) {
                    singleTon2 = new SingleTon2();
                }
            }
        }
        return singleTon2;
    }
}


public class code5 {
    public static void main(String[] args) {
        SingleTon2 singleTon2 = SingleTon2.getSingleTon2();
    }
}
