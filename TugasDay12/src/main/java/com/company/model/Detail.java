package com.company.model;

public class Detail {
    //state
    public int iddetail;
    public int idmhs;
    public int physics;
    public int calculus;
    public int biology;

    public Detail(){
    }

    public Detail (int iddetail, int idmhs, int physics, int calculus, int biology) {
        this.iddetail = iddetail;
        this.idmhs = idmhs;
        this.physics = physics;
        this.calculus = calculus;
        this.biology = biology;
    }

    

    //setter
    public void setiddetail(int iddetail) {
        this.iddetail = iddetail;
    }
    public void setidmhs(int idmhs) {
        this.idmhs = idmhs;
    }
    public void setPhysics(int physics) {
        this.physics = physics;
    }
    public void setCalculus(int calculus) {
        this.calculus = calculus;
    }
    public void setBiology(int biology) {
        this.biology = biology;
    }


    //getter
    public int getiddetail() {
        return iddetail;
    }
    public int getidmhs() {
        return idmhs;
    }
    public int getPhysics() {
        return physics;
    }
    public int getCalculus() {
        return calculus;
    }
    public int getBiology() {
        return biology;
    }
}
