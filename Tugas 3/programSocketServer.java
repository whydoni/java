package com.program;

import java.io.*;
import java.util.*;
import java.net.*;

public class programSocketServer {
    public static void main(String[] args) {
        Properties prop = new Properties();
        OutputStream output = null;
        InputStream input = null;
        try {
            output = new FileOutputStream(args[0]);
            prop.setProperty("IP", "localhost");
            prop.setProperty("port", "5000");
            prop.store(output, null);

            input = new FileInputStream(args[0]);
            prop.load(input);

            int ip = Integer.parseInt(prop.getProperty("port"));
            ServerSocket ss = new ServerSocket(ip);
            Socket s = ss.accept();

            FileReader fr = new FileReader(args[1]);
            int i;
            String datas = "";
            while ((i = fr.read()) != -1) {
                datas += (char) i;
            }
            fr.close();
            String din = "";
            while (!din.equals("4")) {
                DataInputStream req = new DataInputStream(s.getInputStream());
                din = req.readUTF();
                System.out.println(din);
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF(datas);
                dout.flush();
            }
            ss.close();

            //ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
