//package Demo2;
//
//public class MyPriorityQueue {
//    private Object[] heap;
//    private int size;
//    private static final int CAPACITY = 11;
//
//    public MyPriorityQueue() {
//        this.heap = new Object[CAPACITY];
//        this.size = 0;
//    }
//
//    // 插入元素
//    public boolean offer(E element) {
//        if (element == null) {
//            throw new NullPointerException();
//        }
//        ensureCapacity();
//        heap[size] = element;
//        siftUp(size);
//        size++;
//        return true;
//    }
//
//    // 删除并返回最小元素
//    public E poll() {
//        if (isEmpty()) {
//            return null;
//        }
//        E min = (E) heap[0];
//        size--;
//        heap[0] = heap[size];
//        heap[size] = null;
//        siftDown(0);
//        return min;
//    }
//
//    // 查看最小元素
//    public E peek() {
//        return isEmpty() ? null : (E) heap[0];
//    }
//
//    // 判断队列是否为空
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    // 获取队列大小
//    public int size() {
//        return size;
//    }
//
//    // 确保数组有足够的容量
//    private void ensureCapacity() {
//        if (size >= heap.length) {
//            int newCapacity = heap.length + (heap.length >> 1); // 扩容50%
//            Object[] newHeap = new Object[newCapacity];
//            System.arraycopy(heap, 0, newHeap, 0, size);
//            heap = newHeap;
//        }
//    }
//
//    // 上浮操作
//    private void siftUp(int index) {
//        E element = (E) heap[index];
//        while (index > 0) {
//            int parentIndex = (index - 1) / 2;
//            E parent = (E) heap[parentIndex];
//            if (element.compareTo(parent) >= 0) {
//                break;
//            }
//            heap[index] = parent;
//            index = parentIndex;
//        }
//        heap[index] = element;
//    }
//
//    // 下沉操作
//    private void siftDown(int index) {
//        E element = (E) heap[index];
//        int half = size / 2;
//        while (index < half) {
//            int childIndex = 2 * index + 1;
//            E child = (E) heap[childIndex];
//            int rightChildIndex = childIndex + 1;
//            if (rightChildIndex < size && ((E) heap[rightChildIndex]).compareTo(child) < 0) {
//                childIndex = rightChildIndex;
//                child = (E) heap[childIndex];
//            }
//            if (element.compareTo(child) <= 0) {
//                break;
//            }
//            heap[index] = child;
//            index = childIndex;
//        }
//        heap[index] = element;
//    }
//
//    public static void main(String[] args) {
//        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();
//        pq.offer(5);
//        pq.offer(3);
//        pq.offer(8);
//        pq.offer(1);
//
//        System.out.println("Priority Queue Size: " + pq.size());
//        System.out.println("Top element (peek): " + pq.peek());
//
//        System.out.println("Polling elements:");
//        while (!pq.isEmpty()) {
//            System.out.println(pq.poll());
//        }
//
//        System.out.println("Priority Queue Size after polling: " + pq.size());
//    }
//}
//
