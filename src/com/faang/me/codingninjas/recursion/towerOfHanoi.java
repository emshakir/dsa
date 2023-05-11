package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 24/10/2022
 */
public class towerOfHanoi {

    public static void towerOfHanoi(int n, char source, char helper, char destination) {

        if (n == 1) {
            System.out.println(source + " " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, destination, helper);
        System.out.println(source + " " + destination);
        towerOfHanoi(n - 1, helper, source, destination);
    }

    public static void main(String[] args) {
        towerOfHanoi(4, 'a', 'b', 'c');
    }
}
