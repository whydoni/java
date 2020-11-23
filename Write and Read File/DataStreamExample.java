import java.io.FileOutputStream;
import java.io.FileInputStream;
public class DataStreamExample {
    public static void main(String args[]) {
        try {
            FileOutputStream fout = new FileOutputStream("C:/Users/btpnshifted/Documents/BTPNS/Java/" + args[0]);
            // String nama = "Doni W";
            String s=args[1];
            byte b[] = s.getBytes();
            fout.write(b);
            fout.close();
            System.out.println("Success...");

            FileInputStream fin = new FileInputStream("C:/Users/btpnshifted/Documents/BTPNS/Java/" + args[0]);
            int i = 0;
            while((i=fin.read())!=-1) {
                System.out.print((char)i);
            }

            fin.close();
        }catch(Exception e){System.out.println(e);}
    }
}