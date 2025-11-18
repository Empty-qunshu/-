package ch03_queue;

public interface IQueue {
    void clear();             // 队列置空
    boolean isEmpty();        // 判空
    void enqueue(Object x);   // 入队
    Object dequeue();         // 出队
}
