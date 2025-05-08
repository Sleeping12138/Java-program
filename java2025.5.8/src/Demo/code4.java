package Demo;

// 饿汉单例
class SingleTon{
    private SingleTon(){};

    private static final SingleTon singleTon = new SingleTon();

    public static SingleTon getSingleTon(){
        return singleTon;
    }
}


public class code4 {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getSingleTon();
    }
}
