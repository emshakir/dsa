package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 25/10/2022
 */
public class MultiplicationOfTwoIntegers {

    public static int multiplyTwoIntegers(int m, int n) {
        // Write your code here
        if (m == 0 || n == 0) {
            return 0;
        }

        int smallOutput = multiplyTwoIntegers(m, n - 1);
        return smallOutput + m;
    }

    public static void main(String[] args) {
        System.out.println(multiplyTwoIntegers(3, 5));
    }
}
