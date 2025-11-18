package ch03_queue;

public class LinkedQueue implements IQueue {
    // 节点类
    private static class Node {
        Object data;
        Node next;
        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;  // 队头
    private Node rear;   // 队尾

    // 构造方法：初始化为空队列
    public LinkedQueue() {
        front = rear = null;
    }

    // 队列置空
    @Override
    public void clear() {
        front = rear = null;
    }

    // 判空
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    // 入队
    @Override
    public void enqueue(Object x) {
        Node node = new Node(x);
        if (rear == null) {   // 空队列
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    // 出队
    @Override
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object value = front.data;
        front = front.next;
        if (front == null) { // 出队后为空队列
            rear = null;
        }
        return value;
    }
}
