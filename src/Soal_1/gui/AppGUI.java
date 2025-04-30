package Soal_1.gui;

import Soal_1.model.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AppGUI extends JFrame {
    Perusahaan perusahaan = new Perusahaan();
    JTextArea area;

    public AppGUI() {
        setTitle("Manajemen Karyawan");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        area = new JTextArea();
        add(new JScrollPane(area), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton btnAdd = new JButton("Tambah");
        JButton btnCari = new JButton("Cari ID");
        JButton btnFilter = new JButton("Filter Posisi");
        JButton btnGaji = new JButton("Total Gaji");
        JButton btnSave = new JButton("Simpan");
        JButton btnLoad = new JButton("Load");

        panel.add(btnAdd); panel.add(btnCari); panel.add(btnFilter);
        panel.add(btnGaji); panel.add(btnSave); panel.add(btnLoad);
        add(panel, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> tambah());
        btnCari.addActionListener(e -> cari());
        btnFilter.addActionListener(e -> filter());
        btnGaji.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Total Gaji: Rp" + perusahaan.totalGaji()));
        btnSave.addActionListener(e -> {
            try {
                perusahaan.simpanKeFile("karyawan.txt");
                JOptionPane.showMessageDialog(this, "Data disimpan!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        btnLoad.addActionListener(e -> {
            try {
                perusahaan.loadDariFile("karyawan.txt");
                tampilkanSemua();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        tampilkanSemua();
        setVisible(true);
    }

    private void tambah() {
        String id = JOptionPane.showInputDialog("ID");
        if (perusahaan.cariKaryawan(id) != null) {
            JOptionPane.showMessageDialog(this, "ID sudah ada.");
            return;
        }
        String nama = JOptionPane.showInputDialog("Nama");
        String posisi = JOptionPane.showInputDialog("Posisi");
        double gaji = Double.parseDouble(JOptionPane.showInputDialog("Gaji"));

        perusahaan.tambahKaryawan(new Karyawan(id, nama, posisi, gaji));
        tampilkanSemua();
    }

    private void cari() {
        String id = JOptionPane.showInputDialog("Masukkan ID");
        Karyawan k = perusahaan.cariKaryawan(id);
        if (k != null) area.setText(k.toString());
        else JOptionPane.showMessageDialog(this, "Tidak ditemukan");
    }

    private void filter() {
        String posisi = JOptionPane.showInputDialog("Masukkan posisi");
        area.setText("");
        for (Karyawan k : perusahaan.filterPosisi(posisi)) {
            area.append(k + "\n");
        }
    }

    private void tampilkanSemua() {
        area.setText("");
        for (Karyawan k : perusahaan.getSemua()) {
            area.append(k + "\n");
        }
    }
}
