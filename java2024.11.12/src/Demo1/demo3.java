package Demo1;

import java.util.concurrent.ThreadFactory;

//工厂模式的使用
class Student {
    public String name;
    public int age;
}

//工厂类
class StudentFactory {
    //工厂方法
    public static Student studentByNameAndAge(String name, int age) {
        Student student = new Student();
        student.name = name;
        student.age = age;
        return student;
    }

    //工厂方法
    public static Student studentByUsernameAndPassword(String username, int password) {
        Student student = new Student();
        student.name = username;
        student.age = password;
        return student;
    }
}

class MyThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}

public class demo3 {
    public static void main(String[] args) {

    }
}
