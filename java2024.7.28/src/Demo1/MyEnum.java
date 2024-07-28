package Demo1;

public enum MyEnum {
    MON(1),
    TUS(2),
    WES(3),
    THU(4),
    FRI(5),
    ;

    private final int number;
    //可以给枚举对象添加属性变量
    MyEnum(int number) {
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }
}
