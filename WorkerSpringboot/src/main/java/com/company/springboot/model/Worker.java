package com.company.springboot.model;

public abstract class Worker {
    public long id;
    public String Nama;
    public int TjPulsa;
    public int GajiPokok;
    public int Absensi;

    public abstract void tambahAbsensi ();
    public abstract long getId();
    public abstract void setId(long id);
    public abstract String getNama();
    public abstract int getAbsensi();

}
