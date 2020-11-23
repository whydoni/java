import java.io.*;
import java.util.*;
import java.net.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class MyClient {
    public static void main(String[] args) {
        Properties prop = new Properties();
        InputStream input = null;
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        try {
            input = new FileInputStream(args[0]);
            prop.load(input);
            int serv = Integer.parseInt(prop.getProperty("port"));
            String host = prop.getProperty("server");
            Socket s = new Socket(host, serv);
            DataOutputStream cdout = new DataOutputStream(s.getOutputStream());
            DataInputStream cdis = new DataInputStream(s.getInputStream());
            String msg = "";
            while (!msg.equals("EXIT")) {
                System.out.print("\nChat to server : ");
                msg = br.readLine();
                cdout.writeUTF(msg);
                cdout.flush();
                String cstr = (String)cdis.readUTF();
                System.out.println("\nNew message from server : " + cstr);
            }
            cdout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}