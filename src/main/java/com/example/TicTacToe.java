package com.example;

class TicTacToe {
    public static void displayBoard(int[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 0) {
                System.out.print("-");
            } else if (board[i] == 1) {
                System.out.print("X");
            } else if (board[i] == 2) {
                System.out.print("O");
            } else {
                System.out.print("?");
            }

            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }
}
