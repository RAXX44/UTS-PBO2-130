package Soal_2;

public class Kendaraan {
    private String jenis;
    private int lamaParkir;

    public Kendaraan(String jenis) {
        this.jenis = jenis.toLowerCase();
    }

    public double hitungBiaya(int lama) {
        this.lamaParkir = lama;
        double tarif = getTarifPerJam() * lama;

        if (lama > 5) tarif *= 0.9;
        return tarif;
    }

    public double hitungBiaya(int masuk, int keluar) {
        int durasi = keluar - masuk;
        return hitungBiaya(durasi);
    }

    private double getTarifPerJam() {
        return switch (jenis) {
            case "motor" -> 2000;
            case "mobil" -> 5000;
            case "truk" -> 9000;
            default -> 0;
        };
    }

    public void tampilRingkasan(double biaya) {
        System.out.println("\n---- PARKING SUMMARY ----");
        System.out.println("Vehicle Type   : " + capitalize(jenis));
        System.out.println("Parking Time   : " + lamaParkir + " hour(s)");
        System.out.println("Total Fee      : Rp" + biaya);
    }

    private String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
