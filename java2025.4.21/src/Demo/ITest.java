package Demo;

public interface ITest {
    default void print(){
        System.out.println("hello world");
    }
}
