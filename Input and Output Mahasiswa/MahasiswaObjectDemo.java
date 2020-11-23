import java.util.*;
import java.io.*;

// public class MahasiswaObjectDemo {
    // public static void main(String args[]) {
        // MahasiswaObject m1 = new MahasiswaObject(1, "Anto", "Laki-laki");
        // MahasiswaObject m2 = new MahasiswaObject(2, "Amir", "Laki-laki");
        // MahasiswaObject m3 = new MahasiswaObject(3, "Andini", "Perempuan");
        
        // ArrayList<MahasiswaObject> al = new ArrayList<MahasiswaObject>();
        // al.add(m1);
        // al.add(m2);
        // al.add(m3);

        // Iterator itr = al.iterator();

        // while (itr.hasNext()) {
        //     MahasiswaObject st = (MahasiswaObject)itr.next();
        //     System.out.println(st.id+ " " + st.nama + " " + st.gender);
        // };
    // }
// }


public class MahasiswaObjectDemo {
    public static void main(String[] args) throws Exception {
        MahasiswaObject[] dataMahasiswa = {
            new MahasiswaObject(1, "Anto", "Laki-laki"),
            new MahasiswaObject(2, "Amir", "Laki-laki"),
            new MahasiswaObject(3, "Anita", "Perempuan"),
        };
        
        FileOutputStream fout = new FileOutputStream("C:/Users/btpnshifted/Documents/BTPNS/Java/" + args[0]);
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        String mhs1 = "ID : " + dataMahasiswa[0].getID() + ", Nama : " + dataMahasiswa[0].getNama() + ", Gender : " + dataMahasiswa[0].getGender() + "\n";
        String mhs2 = "ID : " + dataMahasiswa[1].getID() + ", Nama : " + dataMahasiswa[1].getNama() + ", Gender : " + dataMahasiswa[1].getGender() + "\n";
        String mhs3 = "ID : " + dataMahasiswa[2].getID() + ", Nama : " + dataMahasiswa[2].getNama() + ", Gender : " + dataMahasiswa[2].getGender() + "\n";
        byte b1[] = mhs1.getBytes();
        byte b2[] = mhs2.getBytes();
        byte b3[] = mhs3.getBytes();
        
        bout.write(b1);
        bout.write(b2);
        bout.write(b3);
        bout.flush();
        bout.close();
        fout.close();
        System.out.println("Write Success...");

        FileInputStream fin = new FileInputStream("C:/Users/btpnshifted/Documents/BTPNS/Java/" + args[0]);
        BufferedInputStream bin = new BufferedInputStream(fin);
        int i = 0;
        while((i=fin.read())!=-1) {
            System.out.print((char)i);
        }

        bin.close();
        fin.close();
        System.out.println("Read Success...");

        // MahasiswaObject[] dataMahasiswa;
        // dataMahasiswa = new MahasiswaObject[3];
        // dataMahasiswa[0] = new MahasiswaObject(1, "Anto", "Laki-laki");
        // dataMahasiswa[1] = new MahasiswaObject(2, "Amir", "Laki-laki");
        // dataMahasiswa[2] = new MahasiswaObject(3, "Anita", "Perempuan");
        
        // for (int i = 0; i<dataMahasiswa.length; i++) {
        //     System.out.println("ID : " + dataMahasiswa[i].getID());
        //     System.out.println("Nama : " + dataMahasiswa[i].getNama());
        //     System.out.println("Gender : " + dataMahasiswa[i].getGender());
        //     System.out.println("");
        // }
    }
}