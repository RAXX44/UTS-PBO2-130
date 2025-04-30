package Soal_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> semuaBiaya = new ArrayList<>();

        System.out.println("===== Welcome to ParkingChan =====");

        String lagi = "y";
        do {
            System.out.print("\nEnter vehicle type (Motor/Mobil/Truk) : ");
            String jenis = input.next();

            Kendaraan kendaraan = new Kendaraan(jenis);

            System.out.print("Enter Duration (Manual/Time): ");
            String metode = input.next();

            double biaya = 0;
            if (metode.equalsIgnoreCase("Manual")) {
                System.out.print("Enter Duration (in hour): ");
                int durasi = input.nextInt();
                biaya = kendaraan.hitungBiaya(durasi);
            } else if (metode.equalsIgnoreCase("Time")) {
                System.out.print("Enter entry time   : ");
                int masuk = input.nextInt();
                System.out.print("Enter exit time    : ");
                int keluar = input.nextInt();
                biaya = kendaraan.hitungBiaya(masuk, keluar);
            } else {
                System.out.println("Invalid input for duration type.");
                continue;
            }

            kendaraan.tampilRingkasan(biaya);
            semuaBiaya.add(biaya);

            input.nextLine();

            System.out.print("\nAdd another vehicle? (y/n): ");
            lagi = input.nextLine();

        } while (lagi.equalsIgnoreCase("y"));

        double total = 0;
        for (double b : semuaBiaya) total += b;

        System.out.println("\n==== FINAL REPORT ====");
        System.out.println("Total Vehicle Final     : " + semuaBiaya.size());
        System.out.println("Total Parking Fees Final: Rp" + total);
        System.out.println("Thank You...");
    }
}
