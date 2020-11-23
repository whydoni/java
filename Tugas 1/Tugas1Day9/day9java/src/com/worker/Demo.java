package com.worker;

import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

@SuppressWarnings("unchecked")
public class Demo {
    public static ArrayList<Staff> StaffList = new ArrayList<>();
    public static ArrayList<Manager> ManagerList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String type = "";
        try {
            while (!type.equals("4")) {
                showMenu();
                type = br.readLine();

                switch (type) {
                    case "1":
                        menu1();
                        break;

                    case "2":
                        menu2();
                        break;

                    case "3":
                        menu3();
                        break;
                }

            }
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    private static void showMenu() {
        System.out.println("\nMenu");
        System.out.println("1. Create Worker");
        System.out.println("2. Create JSON and Write");
        System.out.println("3. Read JSON");
        System.out.println("4. Exit");
    }

    private static void menu1() {
        System.out.println();
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String ID = "";
            String Nama = "";
            String Jabatan = "";
            String email = "";
            String noTel = "";

            System.out.println("Input ID : ");
            ID = br.readLine();

            for (int i = 0; i<StaffList.size(); i++) {
                if (StaffList.get(i).getID() == Integer.parseInt(ID)) {
                    System.out.println("\nThis ID has been used");
                    System.out.println("Input another ID : ");
                    ID = br.readLine();
                }
            }
            for (int i = 0; i<ManagerList.size(); i++) {
                if (ManagerList.get(i).getID() == Integer.parseInt(ID)) {
                    System.out.println("\nThis ID has been used");
                    System.out.println("Input another ID : ");
                    ID = br.readLine();
                }
            }

            System.out.println("\nInput Nama : ");
            Nama = br.readLine();

            System.out.println("\nInput Jabatan : ");
            System.out.println("1. Staff");
            System.out.println("2. Manager");
            Jabatan = br.readLine();

            switch (Jabatan) {
                case "1":
                    System.out.println("\nInput Email : ");
                    email = br.readLine();
                    Staff inputStaff = new Staff(Integer.parseInt(ID), Nama, email);
                    StaffList.add(inputStaff);
                    System.out.println("\nSuccess register staff...!!\n");
                    break;

                case "2":
                    System.out.println("\nInput No Telepon : ");
                    noTel = br.readLine();
                    Manager inputManager = new Manager(Integer.parseInt(ID), Nama, Integer.parseInt(noTel));
                    ManagerList.add(inputManager);
                    System.out.println("\nSuccess register manager...!!\n");
                    break;
            }
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    private static void menu2() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String jenis;
        System.out.println("\n1. Create Staff.txt");
        System.out.println("2. Create Manager.txt");
        System.out.print("\nPilih Menu : ");
        jenis = br.readLine();
        switch (jenis) {
            case "1":
                for (int i = 0; i < StaffList.size(); i++)
                {
                    StaffList.get(i).HitungTunjanganMakan();
                    StaffList.get(i).hitungGajiTotal();
                }
                JSONArray arr = new JSONArray();
                JSONObject employees = new JSONObject();
                for (Staff obj: StaffList){
                    JSONObject obj1=new JSONObject();
                    obj1.put("total gaji",obj.getGajiTotal());
                    obj1.put("tunjangan makan",obj.getTunjanganMakan());
                    obj1.put("tunjangan pulsa",obj.getTunjanganPulsa());
                    obj1.put("email",obj.getEmail().get(0));
                    obj1.put("nama",obj.getNama());
                    obj1.put("id",obj.getID());

                    arr.add(obj1);
                    employees.put("staff",arr);
                }
                try {
                    FileWriter writer = new FileWriter("Staff.txt");
                    BufferedWriter buffer = new BufferedWriter(writer);
                    String jsonText = JSONValue.toJSONString(employees);
                    System.out.println(jsonText);
                    buffer.write(jsonText);
                    buffer.close();
                    writer.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "2":
                for (int i = 0; i < ManagerList.size(); i++)
                {
                    ManagerList.get(i).HitungTunjanganTransport();
                    ManagerList.get(i).HitungTunjanganEntertaint();
                    ManagerList.get(i).hitungGajiTotal();
                }

                JSONArray arr2 = new JSONArray();
                JSONObject employees2 = new JSONObject();
                for (Manager obj: ManagerList){
                    JSONObject obj1=new JSONObject();
                    obj1.put("total gaji",obj.getGajiTotal());
                    obj1.put("tunjangan entertaint",obj.getTunjanganEntertaint());
                    obj1.put("tunjangan transport",obj.getTunjanganTransport());
                    obj1.put("tunjangan pulsa",obj.getTunjanganPulsa());
                    obj1.put("telepon",obj.getTelepon().get(0));
                    obj1.put("nama",obj.getNama());
                    obj1.put("id",obj.getID());

                    arr2.add(obj1);
                    employees2.put("manager",arr2);

                }
                try {
                    FileWriter writer = new FileWriter("Manager.txt");
                    BufferedWriter buffer = new BufferedWriter(writer);
                    String jsonText = JSONValue.toJSONString(employees2);
                    System.out.println(jsonText);
                    buffer.write(jsonText);
                    buffer.close();
                    writer.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }

    }

    private static void menu3() throws IOException {
        InputStreamReader r2 = new InputStreamReader(System.in);
        BufferedReader br2 = new BufferedReader(r2);
        String jenis;
        System.out.println("\n1. Read JSON File Staff");
        System.out.println("2. Read JSON File Manager");
        System.out.print("\nPilih Menu : ");
        jenis = br2.readLine();
        switch (jenis) {
            case "1":
                System.out.print("Masukan nama File : ");
                String filename1 = br2.readLine();
                String textfile = "";
                try{
                    FileReader fr = new FileReader(filename1);
                    BufferedReader br3 = new BufferedReader(fr);
                    int i;
                    while ((i = br3.read()) != -1) {

                        textfile += (char) i;
                    }
                    fr.close();
                    br3.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                Object obj=JSONValue.parse(textfile);
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray elm = (JSONArray) jsonObject.get("staff");
                for (int i = 0, size = elm.size(); i < size; i++)
                {
                    JSONObject objectInArray = (JSONObject)elm.get(i);
                    System.out.println("id : "+objectInArray.get("id"));
                    System.out.println("nama : "+objectInArray.get("nama"));
                    System.out.println("email : "+objectInArray.get("email"));
                    System.out.println("tunjangan pulsa : "+objectInArray.get("tunjangan pulsa"));
                    System.out.println("tunjangan makan : "+objectInArray.get("tunjangan makan"));
                    System.out.println("total gaji : "+objectInArray.get("total gaji")+"\n");
                }
                break;

            case "2":
                System.out.print("Masukan nama File : ");
                String filename2 = br2.readLine();
                String textfile2 = "";
                try{
                    FileReader fr = new FileReader(filename2);
                    BufferedReader br4 = new BufferedReader(fr);
                    int i;
                    while ((i = br4.read()) != -1) {

                        textfile2 += (char) i;
                    }
                    fr.close();
                    br4.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Object obj2=JSONValue.parse(textfile2);
                JSONObject jsonObject2 = (JSONObject) obj2;
                JSONArray elm2 = (JSONArray) jsonObject2.get("manager");
                for (int i = 0, size = elm2.size(); i < size; i++)
                {
                    JSONObject objectInArray = (JSONObject)elm2.get(i);
                    System.out.println("id : "+objectInArray.get("id"));
                    System.out.println("nama : "+objectInArray.get("nama"));
                    System.out.println("telepon : "+objectInArray.get("telepon"));
                    System.out.println("tunjangan pulsa : "+objectInArray.get("tunjangan pulsa"));
                    System.out.println("tunjangan transport : "+objectInArray.get("tunjangan transport"));
                    System.out.println("tunjangan entertaint : "+objectInArray.get("tunjangan entertaint"));
                    System.out.println("total gaji : "+objectInArray.get("total gaji")+"\n");
                }
                break;
        }
    }

}
