package javaImp.Stack;

import java.util.Random;

public class Test<E> {

    /**
     * 测试栈在opCount次操作下需要消耗的时间
     * @param s
     * @param opCount
     * @return
     */
    public static double testStack(Stack<Integer> s, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            s.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            s.pop();
        }

        long end = System.nanoTime();
        return (end - start) * 1.0 / 1e9;
    }

    public static void main(String[] args) {
        // 超过十万时链表栈的性能就不如数组栈了，因为在链表栈中有很多new操作
        final int opCount = 100000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack: " + time1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack: " + time2 + "s");

    }
}
