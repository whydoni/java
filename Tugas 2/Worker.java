public abstract class Worker {
    int IDKaryawan = 0;
    String Nama = "";
    int Absensi = 0;

    public abstract void tambahAbsensi ();
    abstract int getID();
    abstract String getNama();
    abstract int getAbsensi();
    
}