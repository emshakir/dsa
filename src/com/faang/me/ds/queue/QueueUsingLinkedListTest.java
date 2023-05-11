package com.faang.me.ds.queue;

/**
 * Created By Mohammad Shakir - 11/12/2022
 */
public class QueueUsingLinkedListTest {

    public static void main(String[] args) {

        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
        queue.enqueue(17);
        queue.dequeue();
        queue.enqueue(23);
        System.out.println(queue.front());
    }
}
