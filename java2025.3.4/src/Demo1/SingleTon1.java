package Demo1;

public class SingleTon1 {
//    构造器私有化
    private SingleTon1() {
    }

//    创建实例
    private static final SingleTon1 singleTon1 = new SingleTon1();

//    获取对象方法
    public static SingleTon1 getInstance() {
        return singleTon1;
    }
}
