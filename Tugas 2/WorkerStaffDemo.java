import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class WorkerStaffDemo {
    public static ArrayList<Staff> staffList = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String type = "";
        try {
            while (!type.equals("4")) {
                showMenu();
                type = br.readLine();
                String ID = "";
                String Nama = "";
                String Jabatan = "";

                switch (type) {
                    case "1":
                        System.out.println();
                        
                        System.out.println("Input ID : ");
                        ID = br.readLine();

                        System.out.println("Input Nama : ");
                        Nama = br.readLine();

                        System.out.println("Input Jabatan : ");
                        Jabatan = br.readLine();

                        Staff inputKaryawan = new Staff(Integer.parseInt(ID), Nama, Jabatan);
                        staffList.add(inputKaryawan);
                        System.out.println("\nSuccess...!!\n");
                        break;
                    
                    case "2":
                        System.out.println();
                        System.out.println("Masukkan ID Karyawan : ");
                        ID = br.readLine();
                        for (int i = 0; i<staffList.size(); i++) {
                            if (staffList.get(i).getID() == Integer.parseInt(ID)) {
                                staffList.get(i).tambahAbsensi();
                                System.out.println("\nSuccess...!!\n");
                            }
                        }
                        break;

                    case "3":
                        System.out.println();
                        bubbleSort(staffList);
                        String leftAlignFormat = "| %-2s | %-4s | %-7s | %-7s |%n";
                        System.out.format("+----+------+---------+---------+%n");
                        System.out.format("| ID | Nama | Jabatan | Absensi |%n");
                        System.out.format("+----+------+---------+---------+%n");
                        for (Staff str: staffList){
                            System.out.format(leftAlignFormat,str.getID(), str.getNama(), str.getJabatan(), str.getAbsensi());
                            System.out.format("+----+------+---------+---------+%n");
                        }
                        System.out.println(" ");
                        break;
                        
                }

            }
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    private static void showMenu() {
        System.out.println("Menu");
        System.out.println("1. Buat Staff");
        System.out.println("2. Tambah Absensi");
        System.out.println("3. Tampilkan laporan Staff");
        System.out.println("4. Exit");
    }

    public static void bubbleSort(ArrayList<Staff> list)
    {
        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < list.size() - 1; j++)
            {
                if (list.get(j).compareTo(list.get(j + 1)) > 0)
                {
                    Collections.swap(list, j, j + 1);
                }
            }
    }
}