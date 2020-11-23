import java.io.*;
import java.util.*;
import java.net.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

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
            int serv = Integer.parseInt(prop.getProperty("port"));
            ServerSocket ss = new ServerSocket(serv);
            Socket s = ss.accept();
            DataInputStream sdis = new DataInputStream(s.getInputStream());
            DataOutputStream sdout = new DataOutputStream(s.getOutputStream());
            String msg = "";
            while (!msg.equals("EXIT")) {
                String sstr = (String)sdis.readUTF();
                System.out.println("\nNew message from client : " + sstr);
                System.out.print("\nChat to client : ");
                msg = br.readLine();
                sdout.writeUTF(msg);
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
}