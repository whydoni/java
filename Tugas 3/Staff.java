public class Staff extends Worker {
    String Jabatan = "";
    int TunjanganMakan = 0;
    int GajiPokok = 6000000;

    public void HitungTunjanganMakan () {
        TunjanganMakan = Absensi * 20000;
    }

    int getTunjanganMakan () {
        return TunjanganMakan;
    }

    int getGajiPokok () {
        return GajiPokok;
    }

    int getTunjanganPulsa () {
        return TunjanganPulsa;
    }

    public Staff(int newId, String newNama) {
        IDKaryawan = newId;
        Nama = newNama;
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

    public int compareTo(Staff compareID) {
        int compareIDSort = ((Staff ) compareID).getID(); 
        return getID() - compareIDSort;        
    }  

    // public int compareTo(Object o) {
    //     int compare= ((Staff)o).getID();
    //     return this.IDKaryawan-compare;
    // }
}