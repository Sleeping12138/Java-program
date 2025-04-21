package Demo;

// 泛型类
public class MyArray<T> {
    private final T[] array;

    public MyArray(T[] array) {
        this.array = array;
    }

    public T getIndex(int index){
        return array[index];
    }
}
