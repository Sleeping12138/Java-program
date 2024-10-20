package Demo1;

class Student {
    public String name;
    public int age;
}

// 工厂类
class StudentFactory {
    // 工厂方法
    public static Student StudentByNameAndAge(String name, int age) {
        Student student = new Student();
        student.name = "zhangsan";
        student.age = 18;
        return student;
    }
    // 工厂方法
    public static Student studentByUsernameAndPassword(String username, int password) {
        Student student = new Student();
        student.name = "lisi";
        student.age = 12345;
        return student;
    }
}


public class demo4 {
    public static void main(String[] args) {

    }
}
