import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("unchecked")
public class ProgramMahasiswa {
    public static ArrayList<MahasiswaObject> dataMahasiswa = new ArrayList<>();
    public static void main (String[] args) throws Exception {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String type = "";
        try {
            System.out.println("\nWelcome to Student Database\n");
            while(!type.equals("6")) {
            showMenu();
            type = br.readLine();
            

            switch (type){
                case "1":
                    System.out.println();
                    String id = "";
                    String nama = "";
                    String nilai = "";
                    System.out.println("Input ID : ");
                    id = br.readLine();
                    for (int i = 0; i<dataMahasiswa.size(); i++) {
                        if (dataMahasiswa.get(i).getID() == Integer.parseInt(id)) {
                            System.out.println("This ID has been used");
                            System.out.println("Input another ID : ");
                            id = br.readLine();
                        }
                    }

                    System.out.println("Input Name : ");
                    nama = br.readLine();

                    System.out.println("Input Score : ");
                    nilai = br.readLine();

                    MahasiswaObject inputMahasiswa = new MahasiswaObject(Integer.parseInt(id), nama, Integer.parseInt(nilai));
                    dataMahasiswa.add(inputMahasiswa);
                    System.out.println("\nData successfully created\n");
                    break;

                case "2":
                    System.out.println();
                    System.out.println("Input ID that you want to edit : ");
                    id = br.readLine();
                    for (int i = 0; i<dataMahasiswa.size(); i++) {
                        if (dataMahasiswa.get(i).getID() == Integer.parseInt(id)) {
                            System.out.println("\nHere is info about the person with id " + id);
                            System.out.println("Name : "+dataMahasiswa.get(i).getNama());
                            System.out.println("Score : "+dataMahasiswa.get(i).getNilai());
                            
                            System.out.println("\nEdit Name : ");
                            nama = br.readLine();

                            System.out.println("\nEdit Score : ");
                            nilai = br.readLine();
                            
                            MahasiswaObject inputMahasiswa2 = new MahasiswaObject(Integer.parseInt(id), nama, Integer.parseInt(nilai));
                            dataMahasiswa.set(i, inputMahasiswa2);
                            System.out.println("\nData successfully edited\n");
                        }
                    }
                    break;

                case "3":
                    System.out.println();
                    System.out.println("Input ID that you want to remove : ");
                    id = br.readLine();
                    for (int i = 0; i<dataMahasiswa.size(); i++) {
                        if (dataMahasiswa.get(i).getID() == Integer.parseInt(id)) {
                            dataMahasiswa.remove(i);
                            System.out.println("\nData successfully deleted\n");
                        }
                    }
                    break;

                case "4":
                    System.out.println();
                    Collections.sort(dataMahasiswa);
                    for (MahasiswaObject str: dataMahasiswa){
                        System.out.print("ID: "+str.getID()+", Name: "+str.getNama()+", Score: "+str.getNilai() + "\n");
                    }
                    System.out.println(" ");
                    break;

                case "5":
                    System.out.println();
                    FileWriter fw = new FileWriter("dataMahasiswa.txt");
                    Collections.sort(dataMahasiswa);
                    for(MahasiswaObject str: dataMahasiswa){
                        fw.write("ID: "+str.getID()+"\n");
                        fw.write("Name: "+str.getNama()+"\n");
                        fw.write("Score: "+str.getNilai()+"\n");
                        fw.write("\n");
                    }
                    System.out.println("Data successfully saved to dataMahasiswa.txt\n");
                    fw.close();
                    break;
            }
            }
        } catch (Exception e) {System.out.println("Error : " + e);}
    }

    private static void showMenu() {
        System.out.println("Menu List");
        System.out.println("1. Create Student Data");
        System.out.println("2. Edit Student Data");
        System.out.println("3. Remove Student Data");
        System.out.println("4. Print Student Data");
        System.out.println("5. Write Data to dataMahasiswa.txt");
        System.out.println("6. Exit");
    }
}