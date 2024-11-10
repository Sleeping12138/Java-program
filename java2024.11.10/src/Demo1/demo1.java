package Demo1;

// 使用Thread类的子类创建线程
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("hello world");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

// 使用Runnable接口的实现类来创建线程
class MyRunnable implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("hello world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class demo1 {
    public static void main(String[] args) {
//        Thread thread = new Thread(()->{
//            while (true) {
//                System.out.println("hello world");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        thread.start();
//        Thread thread = new MyThread();
//        thread.start();

//        Runnable runnable= new MyRunnable();
//        Thread thread = new Thread(runnable);
//        thread.start();

//        // 使用匿名内部类的方式
//        Thread thread1 = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("hello world");
//            }
//        };
//        thread1.start();
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello Runnable....");
//            }
//        });
//        thread2.start();

//        Thread thread = new Thread(()->{
//            System.out.println("hello world");
//        });
//        thread.start();

//        int number = 100;
//        number = 200;
//        Thread thread = new Thread(()->{
//            for (int i = 0; i < 100; i++) {
//                System.out.println(Thread.currentThread().getName()+" "+number);
//            }
//        });

//        thread.start();
    }
}
