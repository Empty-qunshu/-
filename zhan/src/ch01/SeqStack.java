package ch01;

public class SeqStack implements IStack {
    private final Object[] data;   // 存放栈元素
    private int top;         // 栈顶指针
    private final int maxSize;     // 栈的容量

    public SeqStack(int maxSize) {
        this.maxSize = maxSize;
        data = new Object[maxSize];
        top = -1; // 空栈
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(Object item) {
        if (top == maxSize - 1) {
            throw new RuntimeException("栈已满，无法入栈");
        }
        data[++top] = item;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，无法出栈");
        }
        return data[top--];
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，无法查看栈顶");
        }
        return data[top];
    }

    @Override
    public void clear() {
        top = -1;
    }

    @Override
    public int length() {
        return top + 1;
    }

    // 测试
    public static void main(String[] args) {
        IStack stack = new SeqStack(5);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("栈顶元素: " + stack.peek()); // C
        System.out.println("出栈: " + stack.pop());     // C
        System.out.println("栈长度: " + stack.length()); // 2
        System.out.println("栈是否为空: " + stack.isEmpty()); // false
        stack.clear();
        System.out.println("清空后是否为空: " + stack.isEmpty()); // true
    }
}
