public class Staff extends Worker {
    String Jabatan = "";
    public Staff(int newId, String newNama, String newJabatan) {
        this.IDKaryawan = newId;
        this.Nama = newNama;
        this.Jabatan = newJabatan;
    }
    

    String getJabatan() {
        return Jabatan;
    }

    public int compareTo(Staff compareID) {
        int compareIDSort = ((Staff ) compareID).getID(); 
        return super.getID() - compareIDSort;        
    }  

    // public int compareTo(Object o) {
    //     int compare= ((Staff)o).getID();
    //     return this.IDKaryawan-compare;
    // }
}