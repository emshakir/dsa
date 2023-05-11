package com.faang.me.apnacollege.arrays2D;

/**
 *
 * Created by Mohammad Shakir - 10/04/2023
 */
public class $01_SpiralMatrix {

    public static void printSpiral(int[][] a) {

        int startRow = 0;
        int startCol = 0;
        int endRow = a.length - 1;
        int endCol = a[0].length - 1;

        /**
         * Here for TOP - SR is Fixed RIGHT - EC is Fixed BOTTTOM - ER is Fixed
         * LEFT - SC is Fixed
         */
        while (startRow <= endRow && startCol <= endCol) {

            // TOP - startRow id Fixed
            for (int r = startCol; r <= endCol; r++) {
                System.out.print(a[startRow][r] + " ");
            }

            // RIGHT - endCol is Fixed
            for (int c = startRow + 1; c <= endRow; c++) {
                System.out.print(a[c][endCol] + " ");
            }

            // BOTTOM - endRow is Fixed
            for (int r = endCol - 1; r >= startCol; r--) {
                System.out.print(a[endRow][r] + " ");
            }

            // LEFT - startCol s Fixed
            for (int c = endRow - 1; c >= startRow + 1; c--) {
                System.out.print(a[c][startCol] + " ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static void main(String[] args) {
//        int[][] a = {
//                        {1, 2, 3},
//                        {4, 5, 6},
//                        {7, 8, 9},
//                        {10, 11, 12}
//                    };
        int[][] a = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };
        printSpiral(a);
    }
}
