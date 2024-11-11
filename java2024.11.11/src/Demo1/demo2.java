package Demo1;

// 单例模式的创建

class SingleTonLazy{
    private volatile static SingleTonLazy singleTonLazy = null;
    private static Object locker = new Object();
    private SingleTonLazy(){

    }
    public static SingleTonLazy getSingleTonLazy(){
        if (singleTonLazy==null) {
            synchronized (locker) {
                if(singleTonLazy==null){
                    singleTonLazy = new SingleTonLazy();
                }
            }
        }
        return singleTonLazy;
    }
}

class SingleTon{
    private static SingleTon singleTon = new SingleTon();
    private SingleTon(){

    }
    public static SingleTon getSingleTon(){
        return singleTon;
    }
}

public class demo2 {
    public static void main(String[] args) {

    }
}
