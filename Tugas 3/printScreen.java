package com.program;

public class printScreen extends Thread{
    String data;
    public void run(){
        System.out.println(data);
    }
    printScreen(String data){
        this.data = data;
    }
}

