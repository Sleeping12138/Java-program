package Demo1;
class MyBlockingQueue {
    private String[] data = null;

    // 队首
    private int head = 0;

    // 队尾
    private int tail = 0;

    // 元素个数
    private int size = 0;


    public MyBlockingQueue(int capacity) {
        data = new String[capacity];
    }

    public void put(String elem) throws InterruptedException {
        synchronized (this) {
            while (size >= data.length) {
                // 队列满了. 需要阻塞的
                // return;
                this.wait();
            }
            data[tail] = elem;
            tail++;
            if (tail >= data.length) {
                tail = 0;
            }

            // tail = (tail + 1) % data.length;

            size++;
            this.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (this) {
            while (size == 0) {
                // 队列空了. 需要阻塞
                // return null;
                this.wait();
            }
            String ret = data[head];
            head++;
            if (head >= data.length) {
                head = 0;
            }
            size--;
            this.notify();
            return ret;
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(1000);

        Thread producer = new Thread(() -> {
            int n = 0;
            while (true) {
                try {
                    queue.put(n + "");
                    System.out.println("生产元素 " + n);
                    n++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                String n = null;
                try {
                    n = queue.take();
                    System.out.println("消费元素 " + n);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}


