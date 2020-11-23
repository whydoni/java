import java.util.*;
import java.io.*;
public class writeFile extends Thread {
    public static ArrayList<Mahasiswa> dataMahasiswa;
    public writeFile(ArrayList<Mahasiswa> list) {
        dataMahasiswa = list;
    }
    public void run() {
        try {
            FileWriter fw = new FileWriter("threadMahasiswa.txt");
            System.out.println();
            bubbleSort(dataMahasiswa);
            String leftAlignFormat = " %-2s  %-10s %-14s  %-6s  %-9s %n";
            fw.write(String.format(" ID  Nama       Bahasa Inggris  Fisika  Algoritma %n"));
            for (Mahasiswa data : dataMahasiswa) {
                fw.write(String.format(
                leftAlignFormat,
                data.getID(),
                data.getNama(),
                Double.toString(data.getNilai().get(0)),
                Double.toString(data.getNilai().get(1)),
                Double.toString(data.getNilai().get(2))));
            }
            fw.close();
            System.out.println(" ");
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    public static void bubbleSort(ArrayList<Mahasiswa> list) {
        for (int i = 0; i < list.size(); i++) 
            for (int j = 0;j < list.size() - 1;j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                Collections.swap(list, j, j + 1);
                }
            }
    }
}