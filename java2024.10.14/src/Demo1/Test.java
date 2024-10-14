package Demo1;

import java.util.Scanner;

public class Test {
    //    public static int count = 0;
//
//    public static void main(String[] args) throws InterruptedException {
//        Object locker1 = new Object();
//        Object locker2 = new Object();
//        Thread thread1 = new Thread(()->{
//            synchronized (locker1){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                synchronized (locker2){
//                    System.out.println("ok");
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(()->{
//            synchronized (locker2){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                synchronized (locker1){
//                    System.out.println("ok");
//                }
//            }
//        });
//
////        Thread thread1 = new Thread(() -> {
////            for (int i = 0; i < 50000; i++) {
////                synchronized (locker) {
////                    count++;
////                }
////            }
////        });
////        Thread thread2 = new Thread(() -> {
////            for (int i = 0; i < 50000; i++) {
////                synchronized (locker) {
////                    count++;
////                }
////            }
////        });
//
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//
//        System.out.println(count);
//    }

    public volatile static int flag = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{
            while (flag == 0){

            }
        });

        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Scanner scanner = new Scanner(System.in);
            flag =scanner.nextInt();
            System.out.println("over");
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }


//    public static int count = 0;
//
//    public static void main(String[] args) throws InterruptedException {
//        Object locker = new Object();
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 50000; i++) {
//                synchronized (locker) {
//                    synchronized (locker) {
//                        count++;
//                    }
//                }
//            }
//        });
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 50000; i++) {
//                count++;
//            }
//        });
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//
//        //结果随机 <=10w
//        System.out.println("count = " + count);
//    }


}
