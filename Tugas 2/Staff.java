public class Staff extends Worker {
    String Jabatan = "";
    public Staff(int newId, String newNama, String newJabatan) {
        this.IDKaryawan = newId;
        this.Nama = newNama;
        this.Jabatan = newJabatan;
    }

    public void tambahAbsensi () {
        Absensi = Absensi + 1;
    }

    int getID() {
        return IDKaryawan;
    }

    String getNama() {
        return Nama;
    }

    int getAbsensi() {
        return Absensi;
    }

    String getJabatan() {
        return Jabatan;
    }

    public int compareTo(Staff compareID) {
        int compareIDSort = ((Staff ) compareID).getID(); 
        return this.getID() - compareIDSort;        
    }  

    // public int compareTo(Object o) {
    //     int compare= ((Staff)o).getID();
    //     return this.IDKaryawan-compare;
    // }
}