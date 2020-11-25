package com.company.model;

public class Mahasiswa {
    //state
    public int idmhs;
    public String fullname;
    public String address;
    public String status;
    public int absensi;

    public Mahasiswa(){
    }

    public Mahasiswa(int idmhs, String fullname, String address, String status, int absensi) {
        this.idmhs = idmhs;
        this.fullname = fullname;
        this.address = address;
        this.status = status;
        this.absensi = absensi;
    }

    
    
    //setter
    public void setidmhs(int idmhs) {
        this.idmhs = idmhs;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }

    
    //getter
    public int getidmhs() {
        return idmhs;
    }
    public String getFullname() {
        return fullname;
    }
    public String getAddress() {
        return address;
    }
    public String getStatus() {
        return status;
    }
    public int getAbsensi() {
        return absensi;
    }

}
