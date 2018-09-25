package javaImp.Queue;

import javaImp.LinkedList.LinkedList;

public class Main_LinkedListQueue {
    public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
