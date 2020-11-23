package com.SocketJson;

import java.io.*;
import java.net.*;
import java.util.*;

import java.util.regex.Pattern;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static Socket s;
    public static DataOutputStream dout;
    public static ServerSocket ss;
    public static int port;
    public static String server;
    public static ArrayList<String[]> studentList =new ArrayList<>();

    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);

            server = prop.getProperty("server");
            port = Integer.parseInt(prop.getProperty("port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            ss = new ServerSocket(port);
            System.out.println("Done!");
            System.out.println("Waiting Client to Connect ...");

            String datas = "";
            FileReader fr = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(fr);
            int i;
            while ((i = br.read()) != -1) {

                datas += (char) i;
            }
            fr.close();
            br.close();
            s = ss.accept();

            String[] values = datas.split("\\n");
            JSONArray arr = new JSONArray();
            JSONObject studentList = new JSONObject();
            for (String string : values){
                String[] data = string.split(",");
                JSONObject obj1=new JSONObject();
                for (i = 0; i<data.length; i++){
                    if (i==0){
                        obj1.put("nama",data[i]);
                    } else if (i==1){
                        obj1.put("nilai fisika",data[i]);
                    } else if (i==2){
                        obj1.put("nilai biologi",data[i]);
                    } else if (i==3){
                        obj1.put("nilai kimia",data[i]);
                    }
                }
                arr.add(obj1);

            }
            studentList.put("student",arr);
            String jsonText = JSONValue.toJSONString(studentList);
            System.out.println(jsonText);
            dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF(jsonText);
            dout.flush();
            dout.close();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            System.out.println("Shutdown the Server");
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
