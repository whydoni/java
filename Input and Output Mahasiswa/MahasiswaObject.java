public class MahasiswaObject {
    int id = 0;
    String nama = "";
    String gender = "";

    public MahasiswaObject(int newId, String newNama, String newGender) {
        this.id = newId;
        this.nama = newNama;
        this.gender = newGender;
    }
    
    int getID() {
        return id;
    }

    String getNama() {
        return nama;
    }

    String getGender() {
        return gender;
    }
}