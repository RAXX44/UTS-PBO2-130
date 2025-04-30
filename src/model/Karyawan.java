package model;

import java.io.Serializable;

public class Karyawan implements Serializable {
    private String id, nama, posisi;
    private double gaji;

    public Karyawan(String id, String nama, String posisi, double gaji) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = Math.max(gaji, 0);
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getPosisi() { return posisi; }
    public void setPosisi(String posisi) { this.posisi = posisi; }
    public double getGaji() { return gaji; }
    public void setGaji(double gaji) { this.gaji = Math.max(gaji, 0); }

    public String toString() {
        return id + " | " + nama + " | " + posisi + " | Rp" + gaji;
    }
}
