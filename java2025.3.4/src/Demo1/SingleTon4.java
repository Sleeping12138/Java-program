package Demo1;

public class SingleTon4 {
    private SingleTon4() {
    }

    private static SingleTon4 singleTon4;

    public static synchronized SingleTon4 getInstance() {
        if (singleTon4 == null) {
            singleTon4 = new SingleTon4();
        }
        return singleTon4;
    }
}
