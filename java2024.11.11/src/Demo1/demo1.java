package Demo1;

//// 饿汉模式
//// 只有读操作，不会出现线程安全问题
//class SingleTon {
//    private static SingleTon singleTon = new SingleTon();
//
//    private SingleTon() {
//
//    }
//
//    public static SingleTon getSingleTon() {
//        return singleTon;
//    }
//}
//
//// 懒汉模式
//class SingleTonLazy {
//    private volatile static SingleTonLazy singleTonLazy = null;
//    private static Object locker = new Object();
//
//    private SingleTonLazy() {
//
//    }
//
//    public static SingleTonLazy getSingleTonLazy() {
//        if (singleTonLazy == null) {
//            synchronized (locker) {
//                if (singleTonLazy == null) {
//                    singleTonLazy = new SingleTonLazy();
//                }
//            }
//        }
//        return singleTonLazy;
//    }
//}


// 单例模式的创建
public class demo1 {
    public static void main(String[] args) {
//        SingleTon singleTon1 = SingleTon.getSingleTon();
//        SingleTon singleTon2 = SingleTon.getSingleTon();
//        SingleTon singleTon3 = SingleTon.getSingleTon();
//        System.out.println(singleTon1==singleTon2);
//        System.out.println(singleTon1==singleTon3);
//        System.out.println(singleTon3==singleTon2);


    }
}
