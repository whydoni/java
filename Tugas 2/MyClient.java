import java.io.*;
import java.util.*;
import java.net.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.regex.*;

public class MyClient {
    static Socket s;
    static InputStream input = null;
    static InputStreamReader r = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(r);
    static List<String> data = new ArrayList<String>();
    public static void main(String[] args) {
        try {
            // login();


            
            String menu = "";
            while (!menu.equals("4")) {
                showMenu();
                menu = br.readLine();

                switch (menu) { //jangan make switch, mending pake if
                    case "1":
                        Properties prop = new Properties();
                        input = new FileInputStream(args[0]);
                        prop.load(input);
                        int serv = Integer.parseInt(prop.getProperty("port"));
                        String host = prop.getProperty("server");
                        s = new Socket(host, serv);      
                        break;
                    case "2":
                        System.out.print("\nInput nama file : ");
                        String file = br.readLine();
                        FileReader fr = new FileReader(file);
                        BufferedReader br2 = new BufferedReader(fr);
                        int i;
                        String readFile = "";
                        while ((i = br2.read()) != -1) {
                            readFile += (char) i;
                        }
                        fr.close();
                        br2.close();
                        DataOutputStream cdout = new DataOutputStream(s.getOutputStream());
                        
                        cdout.writeUTF(readFile);
                        cdout.flush();
                        DataInputStream cdis = new DataInputStream(s.getInputStream());
                        String cstr = cdis.readUTF();
                        System.out.println(cstr);
                        break;
                    case "3":
                        s.close();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void showMenu() {
        System.out.println("\nMenu List");
        System.out.println("1. Connect Socket");
        System.out.println("2. Send Data to Server");
        System.out.println("3. Close Socket");
        System.out.println("4. Exit");
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

        if (Pattern.matches(username, "client@mail.com") == false) {
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

        if (Pattern.matches(password, "clientPass=123")) {
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