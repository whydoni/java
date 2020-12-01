package com.company.daos;

import com.google.gson.Gson;
import com.company.model.Mahasiswa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class UserDao {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public void persist(String mhs) {
        beginTransaction();
        Mahasiswa mhs1 = new Gson().fromJson(mhs, Mahasiswa.class);
        entityManager.persist(mhs1);
        commitTransaction();
    }

    public Mahasiswa find(int idmhs) {
        return entityManager.find(Mahasiswa.class, idmhs);
    }

    public void update(String mhs) {
        beginTransaction();
        Mahasiswa mahasiswa = new Gson().fromJson(mhs, Mahasiswa.class);
        Mahasiswa mhs2 = entityManager.find(Mahasiswa.class, mahasiswa.getIdMhs());
        mhs2.setFullname(mahasiswa.getFullname());
        mhs2.setAddress(mahasiswa.getAddress());
        mhs2.setStatus(mahasiswa.getStatus());
        entityManager.merge(mhs);
        commitTransaction();
    }

    public void absen(String idmhs) {
        beginTransaction();
        Mahasiswa mhs = entityManager.find(Mahasiswa.class, Integer.valueOf(idmhs));
        mhs.setAbsensi(mhs.getAbsensi()+1);
        entityManager.merge(mhs);
        commitTransaction();
    }

    private void beginTransaction() {
        try {
            entityTransaction.begin();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    public void commitTransaction() {
        try {
            entityTransaction.commit();

        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
