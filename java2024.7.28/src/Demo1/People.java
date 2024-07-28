package Demo1;

public class People<T> {
    public T name;

    public People(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "name=" + name +
                '}';
    }
}
