package com.worker;

import java.util.ArrayList;

public class Staff extends Worker {
    String Jabatan = "";
    int TunjanganMakan = 0;
    int GajiPokok = 6000000;
    ArrayList<String> email = new ArrayList<>();

    public void HitungTunjanganMakan () {
        TunjanganMakan = Absensi * 20000;
    }

    int getTunjanganMakan () {
        return TunjanganMakan;
    }

    ArrayList<String> getEmail () {
        return email;
    }

    int getGajiPokok () {
        return GajiPokok;
    }
    public void hitungGajiTotal () {
        GajiTotal = GajiPokok + TunjanganMakan + TunjanganPulsa;
    }

    int getGajiTotal () {
        return GajiTotal;
    }

    int getTunjanganPulsa () {
        return TunjanganPulsa;
    }

    public Staff(int newId, String newNama, String newEmail) {
        IDKaryawan = newId;
        Nama = newNama;
        email.add(newEmail);
    }

    public void tambahAbsensi () {
        Absensi = Absensi + 1;
    }

    int getID() {
        return IDKaryawan;
    }

    String getNama() {
        return Nama;
    }

    int getAbsensi() {
        return Absensi;
    }

    public int compareTo(Staff compareID) {
        int compareIDSort = ((Staff ) compareID).getID();
        return getID() - compareIDSort;
    }

    // public int compareTo(Object o) {
    //     int compare= ((Staff)o).getID();
    //     return this.IDKaryawan-compare;
    // }
}
