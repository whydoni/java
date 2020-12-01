package com.company.controller;

import com.company.rabbitmq.Send;
import com.google.gson.Gson;
import com.company.model.Mahasiswa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class APIController {
    Send send = new Send();

    // ---------------------- CREATE NEW MAHASISWA ----------------------
    @RequestMapping(value = "/mhs/", method = RequestMethod.POST)
    public ResponseEntity<?> tambahMhs(@RequestBody Mahasiswa mhs) {
        try {
            send.insertMhs(new Gson().toJson(mhs));
        } catch (Exception e){
            System.out.println("error = " + e);
        }
        return new ResponseEntity<>("Success Insert Mahasiswa...", HttpStatus.OK);
    }



    // ---------------------- UPDATE MAHASISWA ----------------------
    @RequestMapping(value = "/mhs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMhs(@PathVariable("id") int id, @RequestBody Mahasiswa mhs) {
        mhs.setIdMhs(id);
        try {
            send.updateMhsById(new Gson().toJson(mhs));
        }catch (Exception e){
            System.out.println("error = " + e);
        }
        return new ResponseEntity<>("Success Update Mahasiswa", HttpStatus.OK);
    }



    // ---------------------- ABSENSI MAHASISWA ----------------------
    @RequestMapping(value = "/mhs/{id}/absen", method = RequestMethod.PUT)
    public ResponseEntity<?> absensiMhs(@PathVariable("id") int id) {
        try {
            send.absensiMhs(Integer.toString(id));
        } catch (Exception e){
            System.out.println("error = " + e);
        }
        return new ResponseEntity<>("Success Absensi Mahasiswa", HttpStatus.OK);
    }
}
