package Demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Test {
//    public static void main(String[] args) {
//        String str1 = new String("hello");
//        str1.intern();
//        String str2 = "hello";
//        System.out.println(str1 == str2);

//        char[] chArray = {'h','e','l','l','o'};
//        String str1 = new String(chArray);
//        //字符串常量池中没有，所有将创建的字符串对象放入
//        str1.intern();
//        String str2 = "hello";
//        System.out.println(str1==str2);

    //反射 - 获取私有成员
//        Student student = new Student();
//        System.out.println(student.name);

//        try {
//            //通过私有方法获取对象
//            Class<?> c1 = Class.forName("Demo1.Student");
//            Constructor<?> constructor = c1.getDeclaredConstructor(String.class, int.class);
//            constructor.setAccessible(true);
//            Object student = constructor.newInstance("lisi", 18);
//            Student student1 = (Student) student;
//            System.out.println(student1);
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }

    //创建对象
//        try {
//            Class<?> c2 = Class.forName("Demo1.Student");
//            Object student = c2.newInstance();
//            Student student1 = (Student) student;
//            System.out.println(student1);
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }

    //反射成员属性
//        try {
//            Class<?> c3 = Class.forName("Demo1.Student");
//            Field field = c3.getDeclaredField("name");
//            field.setAccessible(true);
//            Object student = c3.newInstance();
//            Student student1 = (Student) student;
//            System.out.println(field.get(student1));
//            field.set(student1, "张三");
//            System.out.println(student1);
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }

    //反射方法
//        try {
//            Class<?> c4 = Class.forName("Demo1.Student");
//            Object student = c4.newInstance();
//            Student student1 = (Student) student;
//            Method method = c4.getDeclaredMethod("eat");
//            method.setAccessible(true);
//            method.invoke(student1);
//
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static void main(String[] args) {
        //枚举类的使用
//        MyEnum ret = MyEnum.MON;
//        int num = switch (ret) {
//            case MON : yield  1;
//            case TUS : yield 2;
//            case WES : yield 3;
//            case THU : yield 4;
//            case FRI : yield 5;
//            default : yield 0;
//        };
//        System.out.println(num);

//        MyEnum fri = MyEnum.FRI;
//        System.out.println(fri.getNumber());

        //Lamba表达式
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {return o1-o2;});


        //集合类的方法
//        forEach

//        HashSet<Integer> set = new HashSet<>();
//        set.add(100);
//        set.add(200);
//        set.add(300);
//        set.add(400);
//
//        set.forEach(new Consumer<Integer>(){
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });

//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(100);
//        arrayList.add(200);
//        arrayList.add(300);
//        arrayList.add(400);
//
//        arrayList.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });

//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(500);
//        list.add(100);
//        list.add(400);
//        list.add(300);
//        list.add(200);

//        list.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });

//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        System.out.println(list);

//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("zhangsan", 88);
//        map.put("lisi", 68);
//        map.put("wangwu", 90);
//        map.put("zhaoliu", 47);
//
//        map.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String s, Integer integer) {
//                System.out.println(s + "  " + integer);
//            }
//        });


        //通配符的上界与下界
        People<String> p1 = new People<>("zhangsan");
        People<Integer> p2 = new People<>(113);
        fun(p1);
        fun(p2);
    }

    public static void fun(People<?> people) {
        System.out.println(people.getName());
    }
}
