import java.io.*;
import java.util.*;
import java.net.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.regex.*;

public class MyServer {
    public static void main(String[] args) {
        Properties prop = new Properties();
	    OutputStream output = null;
        InputStream input = null;
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        try {
            output = new FileOutputStream(args[0]);
            prop.setProperty("server", "localhost");
		    prop.setProperty("port", "6666");
            prop.store(output, null);

            input = new FileInputStream(args[0]);
            prop.load(input);
            // login();

            int serv = Integer.parseInt(prop.getProperty("port"));
            ServerSocket ss = new ServerSocket(serv);
            Socket s = ss.accept();
            String sstr = "";
            DataOutputStream sdout = new DataOutputStream(s.getOutputStream());
            while (!sstr.equals("EXIT")) {
                DataInputStream sdis = new DataInputStream(s.getInputStream());
                sstr = (String)sdis.readUTF();
                String[] values = sstr.split("\n");

                for (String data : values) {
                    String[] item = data.split(",");
                    System.out.print("\nNama : " + item[0]);
                    System.out.print("\nNilai Fisika : " + item[1]);
                    System.out.print("\nNilai Biologi : " + item[2]);
                    System.out.print("\nNilai Kimia : " + item[3] + "\n");
                }

                sdout.writeUTF("Data Done Processing");
                sdout.flush();
            }

            sdout.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
		    if (output != null) {
			    try {
				    output.close();
			    } catch (IOException e) {
				    e.printStackTrace();
			    }
		    }
	    }
    }

    public static void login() throws Exception {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        System.out.println("\nMasukkan username : ");
        String username = br.readLine();
        if (Pattern.matches("([\\w])*@([\\w])*[.]{1}([\\w])*", username) == false) {
            System.out.println("invalid username input, check again");
            username = br.readLine();
        }

        if (Pattern.matches(username, "server@mail.com") == false) {
            System.out.println("username did not match, check again");
            username = br.readLine();
            if (Pattern.matches("([\\w])*@([\\w])*[.]{1}([\\w])*", username) == false) {
              System.out.println("invalid username input, check again");
              username = br.readLine();
            }
        }

        System.out.println("\nMasukkan password : ");
        String password = br.readLine();
        if (Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}", password) ==false) {
            System.out.println("invalid password input, check again");
            password = br.readLine();
        }

        if (Pattern.matches(password, "serverPass=123")) {
            System.out.println("Success login");
        } else {
            System.out.println("username did not match, check again");
            password = br.readLine();
            if (Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}",password) == false) {
              System.out.println("invalid password input, check again");
              password = br.readLine();
            }
        }
    }
}