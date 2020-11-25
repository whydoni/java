package com.company.springboot.controller;

import com.company.springboot.model.Staff;
import com.company.springboot.service.Service;
import com.company.springboot.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") //Mapping url localhost:8080/api/
public class Controller {

    //inisiasi logger
    public static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    Service staffService;

    // -------------------Retrieve All Staff--------------------------------------------

    //Mapping url localhost:8080/api/staff/ dengan method GET
    @RequestMapping(value = "/staff/", method = RequestMethod.GET)
    public ResponseEntity<List<Staff>> listAllStaff() {
        List<Staff> staffs = staffService.findAllStaff(); //memanggil method findAllStaff untuk mengambil semua data staff
        if (staffs.isEmpty()) {
            return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    // -------------------Retrieve Single Staff------------------------------------------

    //Mapping url localhost:8080/api/staff/id dengan method GET
    @RequestMapping(value = "/staff/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStaff(@PathVariable("id") long id) {
        logger.info("Fetching Staff with id {}", id);
        Staff staffs = staffService.findById(id); //memanggil method findById untuk mengambil satu data staff berdasarkan id
        if (staffs == null) {
            logger.error("Staff with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Staff with id " + id  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    // -------------------Create a Staff-------------------------------------------

    //Mapping url localhost:8080/api/staff/ dengan method POST
    @RequestMapping(value = "/staff/", method = RequestMethod.POST)
    public ResponseEntity<?> createStaff(@RequestBody Staff staffs) { //mengambil data staff dari inputan di body API
        logger.info("Creating Staff : {}", staffs);

        if (staffService.isStaffExist(staffs)) {
            logger.error("Unable to create. A Staff with name {} already exist", staffs.getNama());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Staff with name " +
                    staffs.getNama() + " already exist."), HttpStatus.CONFLICT);
        }
        staffService.saveStaff(staffs); //menyimpan data staff

        return new ResponseEntity<>(staffs, HttpStatus.CREATED);
    }

    // ------------------- Update a Staff ------------------------------------------------

    //Mapping url localhost:8080/api/staff/id dengan method PUT
    @RequestMapping(value = "/staff/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStaff(@PathVariable("id") long id, @RequestBody Staff staffs) { //request data dari body API yang akan mengupdate data staff
        logger.info("Updating Staff with id {}", id);

        Staff currentStaff = staffService.findById(id); //mencari id staff

        if (currentStaff == null) {
            logger.error("Unable to update. Staff with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Staff with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }


        staffService.updateStaff(currentStaff); //memanggil method updateStaff
        return new ResponseEntity<>(currentStaff, HttpStatus.OK);
    }

    // ------------------- Delete a Staff-----------------------------------------

    //Mapping url localhost:8080/api/staff/id dengan method DELETE
    @RequestMapping(value = "/staff/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStaff(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Staff with id {}", id);

        Staff staffs = staffService.findById(id);
        if (staffs == null) {
            logger.error("Unable to delete. Staff with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Staff with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        staffService.deleteStaffById(id); //menghapus data staff berdasarkan id
        return new ResponseEntity<Staff>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Staffs-----------------------------

    //Mapping url localhost:8080/api/staff/ dengan method DELETE
    @RequestMapping(value = "/staff/", method = RequestMethod.DELETE)
    public ResponseEntity<Staff> deleteAllStaff() {
        logger.info("Deleting All Staff");

        staffService.deleteAllStaff(); //menghapus semua data staff
        return new ResponseEntity<Staff>(HttpStatus.NO_CONTENT);
    }

}
