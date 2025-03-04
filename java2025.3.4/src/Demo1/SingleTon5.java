package Demo1;

public class SingleTon5 {
    private SingleTon5() {
    }

    private static SingleTon5 singleTon5;
    private static Object locker = new Object();

    public static SingleTon5 getInstance() {
        if (singleTon5 == null) {
            synchronized (locker) {
                if (singleTon5 == null) {
                    singleTon5 = new SingleTon5();
                }
            }
        }
        return singleTon5;
    }
}
