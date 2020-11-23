package com.SocketJson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;


public class Client {
    public static Socket s;
    public static DataOutputStream dout;
    public static DataInputStream dis;
    public static ServerSocket ss;
    public static int port;
    public static String textfile;
    public static String server;
    public static String msg;
    public static boolean LoggedIn = false;
    public static ArrayList<String[]> studentList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        InputStream input = null;
        input = new FileInputStream ("config.properties");
        prop.load(input);
        port = Integer.parseInt(prop.getProperty("port"));
        server = prop.getProperty("server");
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String type = "";
        try {
            while (!type.equals("99")) {
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

                    case "4":
                        menu4();
                }

            }
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    private static void showMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Connect Socket");
        System.out.println("2. Create FileProses.txt");
        System.out.println("3. Print and Upload FileProses");
        System.out.println("4. Close All Connection");
        System.out.println("99. Exit\n");
    }

    private static void menu1() throws IOException {
        try {
            s = new Socket(server, port);
            System.out.println("Connected to Socket Server!");
            dis =new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());

            System.out.println("\nRequest data from server...\n");
            textfile=(String)dis.readUTF();

            dis.close();
            dout.close();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private static void menu2() throws IOException {
        try {
            Object obj= JSONValue.parse(textfile);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray elm = (JSONArray) jsonObject.get("student");
            FileWriter writer = new FileWriter("FileProses.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            for (int i = 0, size = elm.size(); i < size; i++)
            {
                JSONObject objectInArray = (JSONObject)elm.get(i);
                buffer.write("\nNama : "+objectInArray.get("nama")+
                        "\nNilai Fisika : "+objectInArray.get("nilai fisika")+
                        "\nNilai kimia : "+objectInArray.get("nilai kimia")+
                        "\nNilai biologi : "+objectInArray.get("ilai biologi")+
                        "\n");
            }
            buffer.close();
            writer.close();
            System.out.println(jsonObject);

            System.out.println("\nSuccess created FileProcess.txt!");
        }  catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private static void menu3() throws IOException {
        try {
            PrintData printData =new PrintData (textfile);
            FTPUpload uploadFTP = new FTPUpload();
            printData.start();
            uploadFTP.start();

            System.out.println("\nFTP Upload Success!");
        }  catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private static void menu4() throws IOException {
        try {
            System.out.println("Closing All Connection ...");
            s.close();
        }  catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}
