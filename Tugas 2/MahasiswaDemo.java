import java.io.*;
import java.util.*;
import java.util.regex.*;

@SuppressWarnings("unchecked")
public class MahasiswaDemo {

  public static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<Mahasiswa>();

  public static void main(String[] args) throws Exception {
    InputStreamReader r = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(r);
    String type = "";
    try {
      while (!type.equals("4")) {
        showMenu();
        type = br.readLine();
        String id = "";
        String nama = "";
        Double inggris;
        Double fisika;
        Double algor;

        switch (type) {
          case "1":
            menu1();
            break;
          case "2":
            menu2();
            break;
          case "3":
            showLayar s1 = new showLayar(dataMahasiswa);
            writeFile s2 = new writeFile(dataMahasiswa);
            s1.start();
            s2.start();
        }
      }
    } catch (Exception e) {
      System.out.println("Error : " + e);
    }
  }

  private static void showMenu() {
    System.out.println("\nMenu List");
    System.out.println("1. Create Student Data");
    System.out.println("2. Edit or Remove Student Data");
    System.out.println("3. Print Student Data");
    System.out.println("4. Exit");
  }

  private static void menu1() throws Exception {
    try {
      InputStreamReader r = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(r);
      String id = "";
      String nama = "";
      Double inggris;
      Double fisika;
      Double algor;
      System.out.println();
      System.out.println("Input ID : ");
      id = br.readLine();
      for (int i = 0; i < dataMahasiswa.size(); i++) {
        if (dataMahasiswa.get(i).getID() == Integer.parseInt(id)) {
          System.out.println("\nThis ID has been used");
          System.out.println("Input another ID : ");
          id = br.readLine();
        }
      }

      System.out.println("\nInput Name : ");
      nama = br.readLine();

      System.out.println("\nInput Nilai Bahasa Inggris : ");
      inggris = Double.parseDouble(br.readLine());

      System.out.println("\nInput Nilai Fisika : ");
      fisika = Double.parseDouble(br.readLine());

      System.out.println("\nInput Nilai Algoritma : ");
      algor = Double.parseDouble(br.readLine());

      dataMahasiswa.add(
        new Mahasiswa(Integer.parseInt(id), nama, inggris, fisika, algor)
      );
      System.out.println("\nData Successfully Created...!!\n");
    } catch (Exception e) {
      System.out.println("Error : " + e);
    }
  }

  private static void menu2() throws Exception {
    try {
      InputStreamReader r = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(r);
      System.out.println();
      bubbleSort(dataMahasiswa);
      String leftAlignFormat = " %-2s  %-10s %-14s  %-6s  %-9s %n";
      System.out.format(" ID  Nama       Bahasa Inggris  Fisika  Algoritma %n");
      for (Mahasiswa data : dataMahasiswa) {
        System.out.format(
          leftAlignFormat,
          data.getID(),
          data.getNama(),
          Double.toString(data.getNilai().get(0)),
          Double.toString(data.getNilai().get(1)),
          Double.toString(data.getNilai().get(2))
        );
      }
      System.out.println(" ");
    } catch (Exception e) {
      System.out.println("Error : " + e);
    }
  }

  public static void bubbleSort(ArrayList<Mahasiswa> list) {
    for (int i = 0; i < list.size(); i++) for (
      int j = 0;
      j < list.size() - 1;
      j++
    ) {
      if (list.get(j).compareTo(list.get(j + 1)) > 0) {
        Collections.swap(list, j, j + 1);
      }
    }
  }
}
