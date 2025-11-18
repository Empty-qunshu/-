package labQueue;

public interface IQueue {
    public void enqueue(Object x);
    public Object deueue();
    public Object peek();
    public boolean isEmpty();
}
