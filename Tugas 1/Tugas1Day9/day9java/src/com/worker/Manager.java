package com.worker;

import java.util.ArrayList;

public class Manager extends Worker {
    String Jabatan = "";
    int TunjanganTransport = 0;
    int TunjanganEntertaint = 0;
    int GajiPokok = 10000000;
    ArrayList<Integer> Telepon = new ArrayList<>();

    public void HitungTunjanganTransport () {
        TunjanganTransport = Absensi * 50000;
    }

    int getTunjanganTransport () {
        return TunjanganTransport;
    }

    int getGajiPokok () {
        return GajiPokok;
    }

    ArrayList<Integer> getTelepon() {
        return Telepon;
    }

    int getTunjanganPulsa () {
        return TunjanganPulsa;
    }

    public void HitungTunjanganEntertaint () {
        TunjanganEntertaint = Absensi * 500000;
    }

    int getTunjanganEntertaint () {
        return TunjanganEntertaint;
    }

    public Manager(int newId, String newNama, Integer newTel) {
        IDKaryawan = newId;
        Nama = newNama;
        Telepon.add(newTel);
    }

    public void hitungGajiTotal () {
        GajiTotal = GajiPokok + TunjanganEntertaint + TunjanganTransport + TunjanganPulsa;
    }

    int getGajiTotal () {
        return GajiTotal;
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

    public int compareTo(Manager compareID) {
        int compareIDSort = ((Manager ) compareID).getID();
        return getID() - compareIDSort;
    }
}
