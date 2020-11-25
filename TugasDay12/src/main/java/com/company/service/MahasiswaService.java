package com.company.service;

import com.company.model.Detail;
import com.company.model.Mahasiswa;

import java.util.List;

public interface MahasiswaService {
    List<Mahasiswa> findAllMahasiswa();
    List<Mahasiswa> findById(int idmhs);
    int addMahasiswa(Mahasiswa mhs);
    int updateMahasiswa(Mahasiswa mhs);
    int absensi(int idmhs);

    List<Detail> findAllNilai();
    List<Detail> findNilaiById(int idmhs);
    int addNilai(Detail det, int idmhs);
    int updateNilai(Detail det);

    boolean isMahasiswaExist(Mahasiswa mhs);
    boolean isDetailExist(Detail det);
}
