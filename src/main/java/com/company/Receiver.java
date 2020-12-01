package com.company;

import com.company.database.DBReceive;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class Receiver {
    public static EntityManager entityManager = Persistence
            .createEntityManagerFactory("user-unit")
            .createEntityManager();
    public static DBReceive receive = new DBReceive(entityManager);

    public static void main(String[] args) {
        try{
            System.out.println(" [*] Waiting for messages..");
            receive.addMahasiswa();
            receive.updateMahasiswa();
            receive.absensiMahasiswa();
        }catch (Exception e){
            System.out.println("Error = " + e);
        }
    }
}
