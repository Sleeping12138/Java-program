package Demo1;

import java.util.*;

class Student{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
public class demo10 {
    public static void main(String[] args) {
//        TreeMap<String, Integer> map = new TreeMap<>();
//        map.put("Apple", 2);
//        map.put("Banana", 3);
//        map.put("Orange", 1);
//        map.put("Grape", 4);
//
//        // 获取从 "Apple" 到 "Orange" 的所有键值对（包括 "Apple"，不包括 "Orange"）
//        Map<String, Integer> subMap = map.subMap("Apple", true, "Orange", false);
//        System.out.println(subMap);  // 输出: {Apple=2, Banana=3}

        HashMap<String, Integer> map = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
    }
}

