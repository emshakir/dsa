package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 24/10/2022
 */
public class GeometricSum {

    public static double getGeometricSum(int k) {

        if (k == 0) {
            return 1;
        }
        double smallOutput = getGeometricSum(k - 1);
        System.out.println(Math.pow(2, k));
        return smallOutput + 1 / Math.pow(2, k);
    }

    public static void main(String[] args) {
        System.out.println(getGeometricSum(4));
    }
}
