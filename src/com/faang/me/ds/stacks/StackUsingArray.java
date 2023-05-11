package com.faang.me.ds.stacks;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 04/12/2022
 */
public class StackUsingArray {

    private int[] data;
    private int topIndex = -1;

    public StackUsingArray() {
        this.data = new int[10];
        this.topIndex = -1;
    }

    public int size() {
        return topIndex + 1;
    }

    public boolean isEmpty() {
        if (topIndex == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int element) {
        if (topIndex == data.length - 1) {
            increaseSizeOfStack();
        }
        data[++topIndex] = element;
    }

    private void increaseSizeOfStack() {
        data = Arrays.copyOf(data, data.length + 10);
    }

    public int pop() {
        int topElement = data[topIndex];
        data[topIndex--] = 0;
        return topElement;
    }

    public int peek() {
        if (topIndex == -1) {
            return 0;
        } else {
            return data[topIndex];
        }
    }

    @Override
    public String toString() {
        if (topIndex == -1) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i <= topIndex; i++) {
                sb.append(data[i]);
                if (i != topIndex) {
                    sb.append(",");
                }
            }
            return sb + "]";
        }
    }
}
