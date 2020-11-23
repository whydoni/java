public class Worker {
    int IDKaryawan = 0;
    String Nama = "";
    int Absensi = 0;

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
}