package Soal_3;

import java.util.Random;

public class LotreBoard {
    private char[][] board;
    private boolean[][] revealed;
    private int[][] data;
    private final int ROWS = 4;
    private final int COLS = 5;
    private int safeRevealed = 0;

    public LotreBoard() {
        board = new char[ROWS][COLS];
        revealed = new boolean[ROWS][COLS];
        data = new int[ROWS][COLS];
        generateBoard();
    }

    public void generateBoard() {
        // Init board
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0;
            }
        }

        // Place 2 bombs
        Random rand = new Random();
        int bombCount = 0;
        while (bombCount < 2) {
            int r = rand.nextInt(ROWS);
            int c = rand.nextInt(COLS);
            if (data[r][c] == 0) {
                data[r][c] = 1; // 1 = bomb
                bombCount++;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (revealed[i][j]) {
                    if (data[i][j] == 1)
                        System.out.print("X ");
                    else
                        System.out.print("O ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col) {
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            board[row][col] = 'X';
            displayBoard();
            System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
            return false;
        } else {
            board[row][col] = 'O';
            safeRevealed++;
            System.out.println("Kotak Aman");
            return true;
        }
    }

    public boolean isGameOver() {
        return safeRevealed == 18;
    }
}
