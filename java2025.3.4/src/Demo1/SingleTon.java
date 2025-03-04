package Demo1;

public class SingleTon {
    private SingleTon() {
    }

    private static class SingleTon6 {
        private static final SingleTon6 singleTon6 = new SingleTon6();
    }

    public static SingleTon6 getInstance() {
        return SingleTon6.singleTon6;
    }
}
