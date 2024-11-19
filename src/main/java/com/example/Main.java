package com.example;

import static com.example.BackupUtility.backupFiles;
import static com.example.TicTacToe.displayBoard;

public class Main {

    public static void BackupUtility (String[] args) {

        backupFiles("your/source/directory");
    }

    public static void TicTacToe (String[] args) {

        int[] board = {0, 1, 0, 2, 1, 0, 0, 2, 0};
        displayBoard(board);
    }
}
