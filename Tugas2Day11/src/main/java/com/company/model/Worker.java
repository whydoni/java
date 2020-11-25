package com.company.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Worker {
    static final AtomicLong counter = new AtomicLong();
    long IDKaryawan;
    String nama;
    int tjPulsa;
    int gajiPokok;
    int absensiHari;

    public abstract long getIDKaryawan();
    public abstract String getNama();
    public abstract String getEmail();
    public abstract int getTjPulsa();
    public abstract int getGajiPokok();
    public abstract int getAbsensiHari();
}
