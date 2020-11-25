package com.company.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.company.model.Staff;
import com.company.util.ConnectionManager;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
    public static HashMap<Long, Staff> staffs = new HashMap<>();
    public static HashMap<String, Long> nameStaff = new HashMap<>();
    public static Connection con;
    public static Statement stmt;
    public static ConnectionManager c = new ConnectionManager();

    // -------------------------- AMBIL SEMUA DATA STAFF --------------------------
    public ArrayList<Staff> findAllStaff() {
        ArrayList<Staff> st = new ArrayList<Staff>();
        try {
            con = c.on();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staffList");
            while (rs.next()) {
                Staff s = new Staff();
                s.setIDKaryawan(rs.getLong(1));
                s.setNama(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setTjPulsa(rs.getInt(4));
                s.setTjMakan(rs.getInt(5));
                s.setGajiPokok(rs.getInt(6));
                s.setAbsensiHari(rs.getInt(7));
                st.add(s);
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
        c.off();
        return st;
    }

    // -------------------------- AMBIL DATA STAFF BY ID --------------------------
    public Staff findById(long IDKaryawan) {
        Staff s = new Staff();
        try {
            con = c.on();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staffList WHERE id = '"+IDKaryawan+"'");
            while (rs.next()) {

                s.setIDKaryawan(rs.getLong(1));
                s.setNama(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setTjPulsa(rs.getInt(4));
                s.setTjMakan(rs.getInt(5));
                s.setGajiPokok(rs.getInt(6));
                s.setAbsensiHari(rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
        c.off();
        return s;
    }

    // -------------------------- AMBIL DATA STAFF BY NAME --------------------------
    public Staff findByName(String nama) {
        if (nameStaff.get(nama) != null) {
            return staffs.get(nameStaff.get(nama));
        }
        return null;
    }

    // -------------------------- SIMPAN STAFF BARU --------------------------
    public void saveStaff(Staff staff) {
        synchronized (this) {
            try {
                con = c.on();
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO staffList VALUES (null, " +
                        "'"+staff.getNama()+"', " +
                        "'"+staff.getEmail()+"', " +
                        "'"+staff.getTjPulsa()+"', " +
                        "'"+staff.getTjMakan()+"', " +
                        "'"+staff.getGajiPokok()+"'," +
                        "'"+staff.getAbsensiHari()+"')");

            } catch (Exception e) {
                System.out.println("ERROR! -- " + e);
            }
        }
        c.off();
    }

    // -------------------------- UPDATE STAFF --------------------------
    public void updateStaff(Staff staff) {
        synchronized (this) {
            try {
                con = c.on();
                stmt = con.createStatement();
                stmt.executeUpdate("UPDATE staffList SET " +
                        "nama = '"+staff.getNama()+"', " +
                        "email = '"+staff.getEmail()+"', " +
                        "tunjanganPulsa = '"+staff.getTjPulsa()+"', " +
                        "tunjanganMakan = '"+staff.getTjMakan()+"', " +
                        "gajiPokok = '"+staff.getGajiPokok()+"'," +
                        "absensi = '"+staff.getAbsensiHari()+"'" +
                        "WHERE id = '"+staff.getIDKaryawan()+"'");
            } catch (Exception e) {
                System.out.println("ERROR! -- " + e);
            }
            c.off();
        }
    }

    // -------------------------- DELETE STAFF BY ID --------------------------
    public void deletStaffById(long IDKaryawan) {
        synchronized (this) {
            try {
                con = c.on();
                stmt = con.createStatement();
                stmt.executeUpdate("DELETE FROM staffList WHERE id = '"+IDKaryawan+"' ");
            } catch (Exception e) {
                System.out.println("ERROR! -- " + e);
            }
            c.off();
        }
    }

    // -------------------------- DELETE ALL STAFF --------------------------
    public void deletAll() {
        try {
            con = c.on();
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM staffList");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
        c.off();
    }

    // -------------------------- CHECKING IS STAF EXIST? --------------------------
    public boolean isStaffExist(Staff staff) {
        return findByName(staff.getNama()) != null;
    }
}
