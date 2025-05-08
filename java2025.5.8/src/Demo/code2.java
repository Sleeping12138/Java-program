package Demo;

class Storage {
    private int product = 0;

    public synchronized void produce() {
        while (product >= 1) {
            try {
                System.out.println("仓库满了，生产者等待...");
                wait(); // 等待消费者消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("生产者生产了一个产品，当前产品数量：" + product);
        notify(); // 唤醒消费者
    }

    public synchronized void consume() {
        while (product <= 0) {
            try {
                System.out.println("仓库空了，消费者等待...");
                wait(); // 等待生产者生产
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("消费者消费了一个产品，当前产品数量：" + product);
        notify(); // 唤醒生产者
    }
}

public class code2 {
    public static void main(String[] args) throws InterruptedException {
        Storage storage = new Storage();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                storage.produce();
                try {
                    Thread.sleep(500); // 模拟生产耗时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                storage.consume();
                try {
                    Thread.sleep(800); // 模拟消费耗时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("over");
    }
}
