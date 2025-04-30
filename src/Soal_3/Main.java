package Soal_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard game = new LotreBoard();

        System.out.println("Welcome to E-Lottery Gosok");

        while (true) {
            game.displayBoard();
            System.out.print("Masukkan tebakan anda (baris dan kolom) : ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row >= 4 || col < 0 || col >= 5) {
                System.out.println("Input di luar batas! Silakan coba lagi.");
                continue;
            }

            boolean result = game.guess(row, col);
            if (!result) {
                break;
            }

            if (game.isGameOver()) {
                System.out.println("Selamat anda menang!");
                game.displayBoard();
                break;
            }
        }

        scanner.close();
    }
}
