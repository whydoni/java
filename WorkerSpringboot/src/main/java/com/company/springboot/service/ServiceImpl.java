package com.company.springboot.service;

import com.company.springboot.model.Staff;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("staffService")
public class ServiceImpl implements Service {

    //menggunakan HashMap untuk menyimpan data dari API
    private static HashMap<Long, Staff> staffs = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();

    //method untuk mengambil semua data staff
    public List<Staff> findAllStaff() {
        // Pagination should be added...
        return new ArrayList<>(staffs.values());
    }

    //method untuk mengambil satu data berdasarkan id
    public Staff findById(long id) {
        return staffs.get(id);
    }

    //untuk mengambil satu data berdasarkan nama
    public Staff findByName(String name) {

        if (idNameHashMap.get(name) != null){
            return staffs.get(idNameHashMap.get(name));
        }

        return null;
    }


    //untuk menyimpan data staff
    public void saveStaff(Staff staff) {
        synchronized (this) {    //  Critical section synchronized
            staffs.put(staff.getId(), staff);
            idNameHashMap.put(staff.getNama(), staff.getId());
        }
    }

    //untuk mengupdate data staff
    public void updateStaff(Staff staff) {
        synchronized (this) {    //  Critical section synchronized
            staffs.put(staff.getId(), staff);
            idNameHashMap.put(staff.getNama(), staff.getId());
        }
    }

    //untuk menghapus data staff berdasarkan id
    public void deleteStaffById(long id) {
        synchronized (this) {    //  Critical section synchronized
            idNameHashMap.remove(staffs.get(id).getNama());
            staffs.remove(id);
        }
    }

    //mengecek apakah staff exist berdasarkan nama
    public boolean isStaffExist(Staff staff) {
        return findByName(staff.getNama()) != null;
    }

    //menghapus semua data staff
    public void deleteAllStaff() {
        staffs.clear();
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
