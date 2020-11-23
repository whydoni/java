public class MahasiswaObject implements Comparable {
    int id = 0;
    String nama = "";
    int nilai = 0;

    public MahasiswaObject(int newId, String newNama, int newNilai) {
        this.id = newId;
        this.nama = newNama;
        this.nilai = newNilai;
    }
    
    int getID() {
        return id;
    }

    String getNama() {
        return nama;
    }

    int getNilai() {
        return nilai;
    }
    
    @Override
    public int compareTo(Object o) {
        int compare= ((MahasiswaObject)o).getID();
        return this.id-compare;
    }
}