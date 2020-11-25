package com.company.service;

import com.company.model.Staff;

import java.util.ArrayList;

public interface StaffService {
    Staff findById (long IDKaryawan);
    Staff findByName (String nama);

    void saveStaff(Staff staff);
    void updateStaff (Staff staff);
    void deletStaffById (long IDKaryawan);

    ArrayList<Staff> findAllStaff();

    void deletAll();

    boolean isStaffExist(Staff staff);
}
