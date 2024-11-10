package Demo1;

public class demo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello world");
                System.out.println(Thread.currentThread().isAlive());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

//        System.out.println(thread.getId());
//        System.out.println(thread.getName());
//        System.out.println(thread.getState());
//        System.out.println(thread.getPriority());
        System.out.println();

        Thread.sleep(2000);
        System.out.println("main线程结束...");
    }
}
