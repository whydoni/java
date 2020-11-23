public class Manager extends Worker {
    String Jabatan = "";
    int TunjanganTransport = 0;
    int TunjanganEntertaint = 0;
    int GajiPokok = 10000000;

    public void HitungTunjanganTransport () {
        TunjanganTransport = Absensi * 50000;
    }

    int getTunjanganTransport () {
        return TunjanganTransport;
    }

    int getGajiPokok () {
        return GajiPokok;
    }

    
    int getTunjanganPulsa () {
        return TunjanganPulsa;
    }

    public void HitungTunjanganEntertaint (int jumlahEntertaint) {
        TunjanganEntertaint = jumlahEntertaint * 500000;
    }

    int getTunjanganEntertaint () {
        return TunjanganEntertaint;
    }

    public Manager(int newId, String newNama) {
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

    public int compareTo(Manager compareID) {
        int compareIDSort = ((Manager ) compareID).getID(); 
        return getID() - compareIDSort;        
    }  
}