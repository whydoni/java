package com.company.springboot.model;

import java.util.ArrayList;

public class Staff extends Worker {

    int TjMakan;
    int GajiPokok = 6000000;
    int TjPulsa = 250000;
    ArrayList email = new ArrayList();

    //constructor staff
    public Staff(long newId, String newNama, ArrayList newEmail) {
        this.id = newId;
        Nama = newNama;
        this.email = newEmail;
    }

    //getter email
    public ArrayList<String> getEmail () {
        return this.email;
    }

    //setter email
    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }

    //method menambah absensi
    @Override
    public void tambahAbsensi () {
        Absensi = Absensi + 1;
    }

    //setter absensi
    public void setAbsensi(int absensi) {
        this.Absensi = absensi;
    }

    //getter absensi
    @Override
    public int getAbsensi() {
        return Absensi;
    }

    //setter tunjangan makan
    public void setTjMakan (int tunjanganMakan) {
        this.TjMakan = tunjanganMakan;
    }

    //getter tunjangan makan
    public int getTjMakan () {
        return TjMakan;
    }

    //getter gaji pokok
    public int getGajiPokok () {
        return GajiPokok;
    }

    //setter gaji pokok
    public void setGajiPokok(int gajiPokok) {
        this.GajiPokok = gajiPokok;
    }

    //getter tunjangan pulsa
    public int getTjPulsa () {
        return TjPulsa;
    }

    //setter tunjangan pulsa
    public void setTunjanganPulsa(int tunjanganPulsa) {
        this.TjPulsa = tunjanganPulsa;
    }

    //getter id
    @Override
    public long getId() {
        return id;
    }

    //setter id
    @Override
    public void setId(long id) {
        this.id = id;
    }

    //getter nama
    @Override
    public String getNama() {
        return this.Nama;
    }

    //setter nama
    public void setName(String name) {
        this.Nama = name;
    }

}
