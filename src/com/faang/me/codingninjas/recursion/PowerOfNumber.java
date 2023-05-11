package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 20/10/2022
 */
public class PowerOfNumber {

    public static void main(String[] args) {
        int output = pow(3, 4);
        System.out.println("Main Output :: " + output);
    }

    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        System.out.println(n + " nt Recursive call :::: ");
        int smallOutput = pow(x, n - 1);
        System.out.println("Output :::: " + x * smallOutput);
        return x * smallOutput;
    }
}
