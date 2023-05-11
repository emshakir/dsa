package com.faang.me.codingninjas.heaps;

import com.faang.me.codingninjas.heaps.dto.Element;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHAKIR
 */
public class PriorityQueueMin<T> {

    private List<Element<T>> heap;

    public PriorityQueueMin() {
        this.heap = new ArrayList<>();
    }

    public void add(T value, int priority) {

        // add the value at the end of heap
        Element<T> e = new Element(value, priority);
        heap.add(e);

        // get child and parent index
        int child = heap.size() - 1;
        int parent = (child - 1) / 2;

        // swap child with parent untill child is less than parent
        while (heap.get(child).priority < heap.get(parent).priority) {
            Element<T> temp = heap.get(child);
            heap.set(child, heap.get(parent));
            heap.set(parent, temp);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public T remove() {

        // get zeroth index to return
        T data = getMin();

        // swap first element with last
        Element<T> temp = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.set(heap.size() - 1, temp);

        // remove the last element from heap
        heap.remove(heap.size() - 1);

        // fix the heap
//        fixHeap(0);
        fixHeapIterative(0);

        return data;
    }

    private void fixHeap(int idx) {
        int min = idx;

        int leftChild = (2 * idx) + 1;
        int rightChild = (2 * idx) + 2;
        int size = heap.size();

        if (leftChild < size && heap.get(leftChild).priority < heap.get(min).priority) {
            min = leftChild;
        }

        if (rightChild < size && heap.get(rightChild).priority < heap.get(min).priority) {
            min = rightChild;
        }

        if (idx != min) {
            Element<T> temp = heap.get(idx);
            heap.set(idx, heap.get(min));
            heap.set(min, temp);
            fixHeap(min);
        }
    }

    private void fixHeapIterative(int index) {
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;
        int size = heap.size();
        while (leftChild < size) {
            int min = index;
            if (leftChild < size && heap.get(leftChild).priority < heap.get(min).priority) {
                min = leftChild;
            }

            if (rightChild < size && heap.get(rightChild).priority < heap.get(min).priority) {
                min = rightChild;
            }
            if (index == min) {
                break;
            }
            Element<T> temp = heap.get(index);
            heap.set(index, heap.get(min));
            heap.set(min, temp);
            index = min;
            leftChild = (2 * index) + 1;
            rightChild = (2 * index) + 2;
        }
    }

    public T getMin() {
        return heap.get(0).value;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {

        PriorityQueueMin<String> pq = new PriorityQueueMin<>();
        pq.add("abc", 15);
        pq.add("def", 13);
        pq.add("fsas", 90);
        pq.add("fsafsafa", 150);
        pq.add("xvzxvsgsg", 120);

        while (!pq.isEmpty()) {
            System.out.println(pq.getMin());
            pq.remove();
        }
    }
}
