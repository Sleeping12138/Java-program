package Demo2;

// 工厂模式

class Teacher{
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// 工厂类
class TeacherMake{
    public static Teacher getTeacherBynameAndAge(String name,int age){
        Teacher teacher = new Teacher();
        teacher.name = name;
        teacher.age =age;
        return teacher;
    }
    public static Teacher getTeacherByIdnameAndId(String idName,int id){
        Teacher teacher = new Teacher();
        teacher.name = idName;
        teacher.age =id;
        return teacher;
    }
}
public class demo2 {
    public static void main(String[] args) {
        Teacher t = TeacherMake.getTeacherByIdnameAndId("zhangsan", 25);
        System.out.println(t);
    }
}
