import java.util.*;

public class Mahasiswa{
    Integer id;
    String nama = "";
    ArrayList<Double> nilai = new ArrayList<>();

    public Mahasiswa(int newId, String newNama, Double inggris, Double fisika, Double algoritma) {
        this.id = newId;
        this.nama = newNama;
        nilai.add(inggris);
        nilai.add(fisika);
        nilai.add(algoritma);
    }

    ArrayList<Double> getNilai() {
        return nilai;
    }

    Integer getID() {
        return Integer.valueOf(this.id);
    }

    void setNama(String newValue) {
        nama = newValue;
    }

    String getNama() {
        return nama;
    }

    public int compareTo(Mahasiswa compareID) {
        int compareIDSort = ((Mahasiswa ) compareID).getID(); 
        return getID() - compareIDSort;        
    }  

}