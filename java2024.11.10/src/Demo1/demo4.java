package Demo1;

public class demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true) {
                System.out.println("hello world");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

        System.out.println(thread.getState());
        Thread.sleep(500);
        System.out.println(thread.getState());
    }
}
