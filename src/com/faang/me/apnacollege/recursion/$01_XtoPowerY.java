package com.apna_college.recursion;

/**
 * Created By Mohammad Shakir - 10/01/2023
 */
public class $01_XtoPowerY {


    public static long getPowerOfTwoNumbers(int x, long n) {
        if (n == 0) {
            return 1;
        }
        return x * getPowerOfTwoNumbers(x, n - 1);
    }

    public static long getPowOptimised(int x, long n) {
        if (n == 0) {
            return 1;
        }

        long smallOutput = getPowerOfTwoNumbers(x, n / 2);
        long pow = smallOutput * smallOutput;
        if (n % 2 != 0) {
            pow *= x;
        }
        return pow;
    }

    public static void main(String[] args) {
        long num = 60;
        long startBStart = System.currentTimeMillis();
        System.out.println("Power ::: " + getPowerOfTwoNumbers(2, num));
        long startBEnd = System.currentTimeMillis();
        System.out.println("Execution Time ::: " + (startBEnd - startBStart));
        long start = System.currentTimeMillis();
        System.out.println("Power ::: " + getPowOptimised(2, num));
        long end = System.currentTimeMillis();
        System.out.println("Execution time::: " + (end - start));
    }
}
