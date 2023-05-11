package com.apna_college.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Mohammad Shakir - 22/01/2023
 */
public class StackUsingArrayList {

    static List<Integer> data;

    public StackUsingArrayList() {
        this.data = new ArrayList<>();
    }

    public static void push(int e) {
        data.add(e);
    }

    public static int pop() {
        int topIdx = data.size() - 1;
        if (topIdx <= 0) {
            return -1;
        }
        int retData = data.get(topIdx);
        data.remove(topIdx);
        return retData;
    }

    public static int peek() {
        int topIdx = data.size() - 1;
        if (topIdx <= 0) {
            return -1;
        }
        return data.get(topIdx);
    }

    public static boolean isEmpty() {
        return data.isEmpty();
    }

    public static int size() {
        return data.size();
    }

    public static void main(String[] args) {

    }
}
