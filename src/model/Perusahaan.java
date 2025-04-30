package model;

import java.io.*;
import java.util.*;

public class Perusahaan {
    private ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    public void tambahKaryawan(Karyawan k) {
        if (cariKaryawan(k.getId()) == null) daftarKaryawan.add(k);
    }

    public void hapusKaryawan(String id) {
        Karyawan k = cariKaryawan(id);
        if (k != null) daftarKaryawan.remove(k);
    }

    public Karyawan cariKaryawan(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equalsIgnoreCase(id)) return k;
        }
        return null;
    }

    public List<Karyawan> filterPosisi(String posisi) {
        List<Karyawan> hasil = new ArrayList<>();
        for (Karyawan k : daftarKaryawan) {
            if (k.getPosisi().equalsIgnoreCase(posisi)) hasil.add(k);
        }
        return hasil;
    }

    public double totalGaji() {
        double total = 0;
        for (Karyawan k : daftarKaryawan) total += k.getGaji();
        return total;
    }

    public ArrayList<Karyawan> getSemua() {
        return daftarKaryawan;
    }

    public void simpanKeFile(String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(daftarKaryawan);
        oos.close();
    }

    public void loadDariFile(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (!file.exists()) return;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        daftarKaryawan = (ArrayList<Karyawan>) ois.readObject();
        ois.close();
    }
}
