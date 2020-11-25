package com.company.model;

import java.util.ArrayList;

public class Staff extends Worker {
    //state
    int tjMakan;
    String email;


    //setter
    public void setIDKaryawan(long IDKaryawan) {
        this.IDKaryawan = IDKaryawan;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTjPulsa(int newTjPulsa) {
        this.tjPulsa = newTjPulsa;
    }
    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }
    public void setTjMakan(int tjMakan) {
        this.tjMakan = tjMakan;
    }
    public void setAbsensiHari(int absensiHari) {
        this.absensiHari = absensiHari;
    }


    //getter
    public String getNama() {
        return nama;
    }
    public long getIDKaryawan() {
        return IDKaryawan;
    }
    public String getEmail() {
        return email;
    }
    public int getTjPulsa() {
        return tjPulsa;
    }
    public int getGajiPokok() {
        return gajiPokok;
    }
    public int getTjMakan() {
        return tjMakan;
    }
    public int getAbsensiHari() {
        return absensiHari;
    }


}
