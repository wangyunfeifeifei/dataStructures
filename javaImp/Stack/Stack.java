package javaImp.Stack;

public interface Stack<E> {

    int getSize(); // 获取栈的大小
    boolean isEmpty(); // 判断是否为空
    void push(E e); // 添加一个元素
    E pop(); // 退出最后一个元素
    E peek(); // 查看最后一个元素
}
