package com.faang.me.apnacollege.backtracking;

class $03_NQueen_Count {

    private static long count = 0;

    public static void nQueens(char[][] b, int row) {

        if (row == b.length) {
//            printBoard(b);
            count++;
            return;
        }

        for (int j = 0; j < b.length; j++) {
            if (isSafe(b, row, j)) {
                b[row][j] = 'Q';
                nQueens(b, row + 1);
                b[row][j] = 'X';
            }
        }

    }

    public static void printBoard(char[][] b) {

        System.out.println("---------- NEW BOARD ------------");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char[][] b, int row, int col) {

        // Vertical Upwards, Need to reduce row, column will remain same
        for (int i = row - 1; i >= 0; i--) {
            if (b[i][col] == 'Q') {
                return false;
            }
        }

        // Left Diagonal, need to reduce row and j
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (b[i][j] == 'Q') {
                return false;
            }
        }

        // Right Diagonal, need to reduce row and increase column
        for (int i = row - 1, j = col + 1; i >= 0 && j < b.length; i--, j++) {
            if (b[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final int BOARD_SIZE = 15;
        char[][] b = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                b[i][j] = 'X';
            }
        }
        nQueens(b, 0);
        System.out.println("Number of Possible N Queen Boards :" + count);
    }
}
