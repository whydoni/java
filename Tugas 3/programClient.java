package com.program;

import java.io.*;
import java.util.*;
import java.net.*;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class programClient {
    static InputStreamReader r=new InputStreamReader(System.in);
    static BufferedReader br=new BufferedReader(r);
    static Socket s;
    static String datas;

    public static void main(String[] args) {
        try {
            String menu = "";
            while (!menu.equals("99")) {
                showMenu();
                menu = br.readLine();
                switch (menu) {
                    case "1":
                        connSocket();
                        break;
                    case "2":
                        createFile();
                        break;
                    case "3":
                        multiThread();
                        break;
                    case "4":
                        downloadFTP();
                        break;
                    case "5":
                        closeConn();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showMenu() {
        System.out.println("\nMenu List");
        System.out.println("1. Connect Socket");
        System.out.println("2. Create FileProses.txt");
        System.out.println("3. Print, write, connect FTP");
        System.out.println("4. Download from FTP Server");
        System.out.println("5. Close All Connection");
        System.out.println("99. EXIT");
    }

    public static void connSocket() {
        try {
            Properties prop = new Properties();
            InputStream input = null;
            input = new FileInputStream("C:\\Users\\btpnshifted\\IdeaProjects\\FTPSocket\\src\\com\\program\\config.properties");
            prop.load(input);
            String ip = prop.getProperty("IP");
            int port = Integer.parseInt(prop.getProperty("port"));
            s = new Socket(ip,port);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Request Data");
            dout.flush();
            DataInputStream din = new DataInputStream(s.getInputStream());
            datas = din.readUTF();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createFile() {
        try {
            String file = "";

            String[] split1 = datas.split("\\n");
            for (String string : split1) {
                String[] data2 = string.split("\\,");
                for (int i = 0; i < data2.length; i++) {
                    if(i==0){
                        file += "Nama : " + data2[i] + "\n";
                    }else if (i==1) {
                        file += "Nilai Fisika : " + data2[i] + "\n";
                    }else if (i==2) {
                        file += "Nilai Biologi : " + data2[i] + "\n";
                    }else if (i==3) {
                        file += "Nilai Kimia : " + data2[i] + "\n\n";
                    }
                }
            }
            FileWriter fr = new FileWriter("FileProses.txt");
            fr.write(file);
            fr.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void multiThread() {
        try {
            String file = "";
            String[] split1 = datas.split("\\n");
            // Perulangan untuk mengubah format data
            for (String string : split1) {
                String[] data = string.split("\\,");
                for (int i = 0; i < data.length; i++) {
                    if(i==0){
                        file += "Nama : " + data[i] + "\n";
                    }else if (i==1) {
                        file += "Nilai Fisika : " + data[i] + "\n";
                    }else if (i==2) {
                        file += "Nilai Biologi : " + data[i] + "\n";
                    }else if (i==3) {
                        file += "Nilai Kimia : " + data[i] + "\n\n";
                    }
                }
            }
            printScreen t1 = new printScreen(file);
            Average t2 = new Average(datas);
            FTPUpload t3 = new FTPUpload();
            t1.start();
            t2.start();
            t3.start();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void downloadFTP() {
        try {
            String server = "ftp.myth.co.id";
            int port = 21;
            String user = "ftpuser@myth.co.id";
            String pass = "password";

            FTPClient ftpClient = new FTPClient();
            try {

                ftpClient.connect(server, port);
                ftpClient.login(user, pass);
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                String remoteFile1 = "/download/average.txt";
                File downloadFile1 = new File("C:/Users/btpnshifted/Documents/BTPNS/ShiftED/average.txt");
                OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
                outputStream1.close();

                if (success) {
                    System.out.println("Download success");
                }
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                try {
                    if (ftpClient.isConnected()) {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void closeConn() {
        try {
            s.close();
            System.out.println("Disconnected...");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
