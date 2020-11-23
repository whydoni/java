import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class WorkerStaffDemo {
    public static ArrayList<Staff> StaffList = new ArrayList<>();
    public static ArrayList<Manager> ManagerList = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String type = "";
        try {
            while (!type.equals("6")) {
                showMenu();
                type = br.readLine();
                String ID = "";
                String Nama = "";
                String Jabatan = "";

                switch (type) {
                    case "1":
                        menu1();
                        break;
                    
                    case "2":
                        menu2();
                        break;
                    
                    case "3":
                        menu3();
                        break;

                    case "4":
                        menu4();
                        break;

                    case "5":
                        menu5();
                        break;
                        
                }

            }
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    private static void showMenu() {
        System.out.println("\nMenu");
        System.out.println("1. Register Pegawai");
        System.out.println("2. Absensi Pegawai");
        System.out.println("3. Hitung Tunjangan");
        System.out.println("4. Hitung Total Gaji");
        System.out.println("5. Laporan Gaji Pegawai");
        System.out.println("6. Exit");
    }

    private static void menu1() {
        System.out.println();
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String ID = "";
            String Nama = "";
            String Jabatan = "";
                            
            System.out.println("Input ID : ");
            ID = br.readLine();

            for (int i = 0; i<StaffList.size(); i++) {
                if (StaffList.get(i).getID() == Integer.parseInt(ID)) {
                    System.out.println("\nThis ID has been used");
                    System.out.println("Input another ID : ");
                    ID = br.readLine();
                }
            }
            for (int i = 0; i<ManagerList.size(); i++) {
                if (ManagerList.get(i).getID() == Integer.parseInt(ID)) {
                    System.out.println("\nThis ID has been used");
                    System.out.println("Input another ID : ");
                    ID = br.readLine();
                }
            }

            System.out.println("\nInput Nama : ");
            Nama = br.readLine();

            System.out.println("\nInput Jabatan : ");
            System.out.println("1. Staff");
            System.out.println("2. Manager");
            Jabatan = br.readLine();

            switch (Jabatan) {
                case "1":
                    Staff inputStaff = new Staff(Integer.parseInt(ID), Nama);
                    StaffList.add(inputStaff);
                    System.out.println("\nSuccess register staff...!!\n");
                    break;
                                
                case "2":
                    Manager inputManager = new Manager(Integer.parseInt(ID), Nama);
                    ManagerList.add(inputManager);
                    System.out.println("\nSuccess register manager...!!\n");
                    break;
            }
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    private static void menu2() {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String ID = "";
            String Nama = "";
            String Jabatan = "";
            System.out.println();
            System.out.println("\n1. Absensi Staff");
            System.out.println("2. Absensi Manager");
            Jabatan = br.readLine();

            switch(Jabatan) {
                case "1":
                    System.out.println("\nInput ID : ");
                    ID = br.readLine();
                    for (int i = 0; i<StaffList.size(); i++) {
                        if (StaffList.get(i).getID() == Integer.parseInt(ID)) {
                            StaffList.get(i).tambahAbsensi();
                            System.out.println("\nBerhasil Absensi...!!\n");
                        }
                    }
                    break;

                case "2":
                    System.out.println("\nInput ID : ");
                    ID = br.readLine();
                    for (int i = 0; i<ManagerList.size(); i++) {
                        if (ManagerList.get(i).getID() == Integer.parseInt(ID)) {
                            ManagerList.get(i).tambahAbsensi();
                            System.out.println("\nBerhasil Absensi...!!\n");
                        }
                    }
                    break;
        }
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    private static void menu3() {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String ID = "";
            String Nama = "";
            String Jabatan = "";
            System.out.println("\n1. Tunjangan Staff");
            System.out.println("2. Tunjangan Manager");
            Jabatan = br.readLine();

            switch (Jabatan) {
                case "1":
                    System.out.println("\nInput ID : ");
                    ID = br.readLine();
                    for (int i = 0; i<StaffList.size(); i++) {
                        if (StaffList.get(i).getID() == Integer.parseInt(ID)) {
                            System.out.println("\nNama : ");
                            System.out.println(StaffList.get(i).getNama());
                            StaffList.get(i).HitungTunjanganMakan();
                            System.out.println("\nTunjangan Makan : ");
                            System.out.println(StaffList.get(i).getTunjanganMakan());
                        }
                    }
                    break;

                case "2":
                    System.out.println("\n1. Tunjangan Transport");
                    System.out.println("2. Tunjangan Entertaint");
                    String jenis = "";
                    jenis = br.readLine();

                    switch (jenis) {
                        case "1":
                            System.out.println("\nInput ID : ");
                            ID = br.readLine();
                            for (int i = 0; i<ManagerList.size(); i++) {
                                if (ManagerList.get(i).getID() == Integer.parseInt(ID)) {
                                    ManagerList.get(i).HitungTunjanganTransport();
                                    System.out.println("\nNama : ");
                                    System.out.println(ManagerList.get(i).getNama());
                                    System.out.println("\nTunjangan Transport : ");
                                    System.out.println(ManagerList.get(i).getTunjanganTransport());
                                }
                            }
                            break;
                                
                        case "2":
                            System.out.println("\nInput ID : ");
                            ID = br.readLine();

                            System.out.println("\nInput jumlah Entertaint : ");
                            String jumlah = "";
                            jumlah = br.readLine();
                            for (int i = 0; i<ManagerList.size(); i++) {
                                if (ManagerList.get(i).getID() == Integer.parseInt(ID)) {
                                    ManagerList.get(i).HitungTunjanganEntertaint(Integer.parseInt(jumlah));
                                    System.out.println("\nNama : ");
                                    System.out.println(ManagerList.get(i).getNama());
                                    System.out.println("\nTunjangan Entertaint : ");
                                    System.out.println(ManagerList.get(i).getTunjanganEntertaint());
                                }
                            }
                            break;
                    }
                    break;
            }
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    private static void menu4() {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String ID = "";
            String Nama = "";
            String Jabatan = "";
            int totalGaji = 0;
            int gajiTemp = 0;
            System.out.println("\n1. Total Gaji Staff");
            System.out.println("2. Total Gaji Manager");
            Jabatan = br.readLine();

            switch(Jabatan) {
                case "1":
                    for (Staff str: StaffList){
                            str.HitungTunjanganMakan();
                            gajiTemp = str.getGajiPokok() + 
                            str.getTunjanganMakan() + 
                            str.getTunjanganPulsa();
                            totalGaji = totalGaji + gajiTemp;
                        }
                    System.out.println("\nTotal Gaji Staff : " + totalGaji);
                    break;
                        
                case "2":
                    for (Manager str: ManagerList){
                            gajiTemp = str.getGajiPokok() + 
                            str.getTunjanganTransport() + 
                            str.getTunjanganEntertaint() + 
                            str.getTunjanganPulsa();
                            totalGaji = totalGaji + gajiTemp;
                        }
                    System.out.println("\nTotal Gaji Manager : " + totalGaji);
                    break;
            }
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    private static void menu5() {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String ID = "";
            String Nama = "";
            String Jabatan = "";
            System.out.println();
            sortStaff(StaffList);
            sortManager(ManagerList);
            String leftAlignFormat = "| %-2d | %-8s | %-7s | %-10d |%n";
            System.out.format("+----+----------+---------+------------+%n");
            System.out.format("| ID |   Nama   | Jabatan | Gaji Total |%n");
            System.out.format("+----+----------+---------+------------+%n");
            for (Staff str: StaffList){
                System.out.format(leftAlignFormat,str.getID(), str.getNama(), "Staff", str.getGajiPokok() + str.getTunjanganMakan() + str.getTunjanganPulsa());
                System.out.format("+----+----------+---------+------------+%n");
            }
            for (Manager str: ManagerList){
                System.out.format(leftAlignFormat,str.getID(), str.getNama(), "Manager", str.getGajiPokok() + 
                str.getTunjanganTransport() + str.getTunjanganEntertaint() + str.getTunjanganPulsa());
                System.out.format("+----+----------+---------+------------+%n");
            }
            System.out.println(" ");

            FileWriter fw = new FileWriter("dataPegawai.txt");
            fw.write(String.format("+----+----------+---------+------------+%n"));
            fw.write(String.format("| ID |   Nama   | Jabatan | Gaji Total |%n"));
            fw.write(String.format("+----+----------+---------+------------+%n"));
                        
            for (Staff str: StaffList){
                fw.write(String.format(leftAlignFormat,str.getID(), str.getNama(), "Staff", str.getGajiPokok()+str.getTunjanganMakan()));
                fw.write(String.format("+----+----------+---------+------------+%n"));
            }
            for (Manager str: ManagerList){
                fw.write(String.format(leftAlignFormat,str.getID(), str.getNama(), "Manager", str.getGajiPokok() + 
                str.getTunjanganTransport() + str.getTunjanganEntertaint()));
                fw.write(String.format("+----+----------+---------+------------+%n"));
            }
                        
            System.out.println("Data telah tersimpan di dataPegawai.txt\n");
            fw.close();

        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    public static void sortStaff(ArrayList<Staff> list) {
        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < list.size() - 1; j++)
            {
                if (list.get(j).compareTo(list.get(j + 1)) > 0)
                {
                    Collections.swap(list, j, j + 1);
                }
            }
    }

    public static void sortManager(ArrayList<Manager> list) {
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