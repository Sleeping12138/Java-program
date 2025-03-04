package Demo1;

public class SingleTon3 {
    private SingleTon3() {
    }

    private static SingleTon3 singleTon3;

    public static SingleTon3 getInstance() {
        if (singleTon3 == null) {
            singleTon3 = new SingleTon3();
        }
        return singleTon3;
    }
}
