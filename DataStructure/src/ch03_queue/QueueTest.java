package ch03_queue;

public class QueueTest {
    public static void main(String[] args) {
        IQueue q = new LinkedQueue();

        System.out.println("队列是否为空：" + q.isEmpty());
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        System.out.println("出队：" + q.dequeue());
        System.out.println("出队：" + q.dequeue());
        System.out.println("队列是否为空：" + q.isEmpty());
        q.clear();
        System.out.println("清空后是否为空：" + q.isEmpty());
    }
}
