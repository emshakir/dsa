package com.apna_college.recursion;

/**
 * Created By Mohammad Shakir - 10/01/2023
 */
public class $03_FriendsPairing {


    public static int friendsPair(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int fnm1 = friendsPair(n - 1);
        int fnm2 = friendsPair(n - 2);
        int pairWays = fnm1 + (n - 1) * fnm2;
        return pairWays;

    }

    public static void main(String[] args) {
        int num = 6;
        System.out.println(friendsPair(num));
    }
}
