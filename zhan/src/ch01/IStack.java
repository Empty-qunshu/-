package ch01;

public interface IStack {
    boolean isEmpty();   // 判断栈是否为空
    void push(Object item); // 入栈
    Object pop();        // 出栈并返回栈顶元素
    Object peek();       // 获取栈顶元素但不删除
    void clear();        // 清空栈
    int length();        // 返回栈中元素个数
}
