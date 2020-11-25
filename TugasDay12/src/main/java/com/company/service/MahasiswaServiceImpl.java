package com.company.service;

import com.company.model.Detail;
import com.company.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service("MahasiswaService")

public class MahasiswaServiceImpl implements MahasiswaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Qualifier("Mahasiswa")

    public List<Mahasiswa> findAllMahasiswa() {
        return jdbcTemplate.query(
                "SELECT * FROM header",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getInt("idmhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    public List<Mahasiswa> findById(int idmhs) {
        return jdbcTemplate.query(
                "SELECT * FROM header WHERE idmhs='"+idmhs+"'",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getInt("idmhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    public int addMahasiswa(Mahasiswa mhs) {
        return jdbcTemplate.update(
                "INSERT INTO header VALUES (?,?,?,?,?)",
                null, mhs.getFullname(), mhs.getAddress(), mhs.getStatus(), mhs.getAbsensi()
        );
    }

    public int updateMahasiswa(Mahasiswa mhs) {
        return jdbcTemplate.update(
                "UPDATE header SET fullname=?, address=?, status=?, absensi=? WHERE idmhs=?",
                mhs.getFullname(), mhs.getAddress(), mhs.getStatus(), mhs.getAbsensi(), mhs.getidmhs()
        );
    }

    public int absensi(int idmhs) {
        return jdbcTemplate.update(
                "UPDATE header SET absensi = absensi+1 WHERE idmhs=?",
                idmhs
        );
    }





    public List<Detail> findAllNilai() {
        return jdbcTemplate.query(
                "SELECT * FROM detail",
                (rs, rowNum) ->
                        new Detail(
                                rs.getInt("iddetail"),
                                rs.getInt("idmhs"),
                                rs.getInt("physics"),
                                rs.getInt("calculus"),
                                rs.getInt("biology")
                        )
        );
    }

    public List<Detail> findNilaiById(int idmhs) {
        return jdbcTemplate.query(
                "SELECT * FROM detail WHERE idmhs='"+idmhs+"'",
                (rs, rowNum) ->
                        new Detail(
                                rs.getInt("iddetail"),
                                rs.getInt("idmhs"),
                                rs.getInt("physics"),
                                rs.getInt("calculus"),
                                rs.getInt("biology")
                        )
        );
    }

    public int addNilai(Detail det, int idmhs) {
        return jdbcTemplate.update(
                "INSERT INTO  detail VALUE (?,?,?,?,?)",
                null, idmhs, det.getPhysics(), det.getCalculus(), det.getBiology()
        );
    }

    public int updateNilai(Detail det) {
        return jdbcTemplate.update(
                "UPDATE detail SET physics=?, calculus=?, biology=? WHERE idmhs=?",
                det.getPhysics(), det.getCalculus(), det.getBiology(), det.getidmhs()
        );
    }





    public boolean isMahasiswaExist(Mahasiswa mhs) {
        List<Mahasiswa> m = jdbcTemplate.query(
                "Select * from header where fullname='"+mhs.getFullname()+"'",
                new BeanPropertyRowMapper(Mahasiswa.class));

//        return customers;
//       jdbcTemplate.execute("Select * from header where fullName='"+mhs.getFullName()+"'");
        if (m.size()!=0){
            return true;
        } else {
            return false;
        }
    }

    public boolean isDetailExist(Detail det) {
        List<Detail> n = jdbcTemplate.query(
                "Select * from detail where idmhs='"+det.getidmhs()+"'",
                new BeanPropertyRowMapper(Detail.class));

//        return customers;
//       jdbcTemplate.execute("Select * from header where fullName='"+mhs.getFullName()+"'");
        if (n.size()!=0){
            return true;
        } else {
            return false;
        }
    }
}
