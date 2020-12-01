package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "Header")
public class Mahasiswa {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    public int idmhs;
    public String fullname;
    public String address;
    public String status;
    public int absensi;

    public Mahasiswa(){
    }

    public Mahasiswa(String fullname, String address, String status, int absensi) {
        this.setFullname(fullname);
        this.setAddress(address);
        this.setStatus(status);
        this.setAbsensi(absensi);
    }

    //setter
    public void setIdMhs(int idmhs) {
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
    public int getIdMhs() {
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
