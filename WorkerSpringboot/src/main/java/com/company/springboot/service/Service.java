package com.company.springboot.service;

import com.company.springboot.model.Staff;

import java.util.List;

public interface Service {
    Staff findById(long id);

    Staff findByName(String name);

    void saveStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaffById(long id);

    List<Staff> findAllStaff();

    void deleteAllStaff();

    boolean isStaffExist(Staff staff);
}
