package Demo;

class Student {
    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// 工厂类
class StudentFactory {
    public static Student getStudentByName(String name) {
        Student student = new Student();
        student.setName(name);
        student.setAge(18);
        return student;
    }

    public static Student getStudentBySchoolNumber(String schoolNumber) {
        Student student = new Student();
        student.setName(schoolNumber);
        student.setAge(18);
        return student;
    }
}

public class code6 {
    public static void main(String[] args) {

    }
}
