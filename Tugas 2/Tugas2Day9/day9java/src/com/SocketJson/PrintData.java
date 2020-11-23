package com.SocketJson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class PrintData extends Thread {
    String data;
    PrintData(String reqData){
        this.data = reqData;
    }
    public void run(){
        Object obj= JSONValue.parse(data);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray elm = (JSONArray) jsonObject.get("student");
        for (int i = 0, size = elm.size(); i < size; i++)
        {
            JSONObject objectInArray = (JSONObject)elm.get(i);
            System.out.println("Nama : "+objectInArray.get("nama")+
                    "\nNilai Fisika : "+objectInArray.get("nilai fisika")+
                    "\nNilai Kimia : "+objectInArray.get("nilai kimia")+
                    "\nNilai Biologi : "+objectInArray.get("nilai biologi")+
                    "\n\n");
        }

    }
}

