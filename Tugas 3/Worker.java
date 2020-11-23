public abstract class Worker {
    int IDKaryawan = 0;
    String Nama = "";
    int TunjanganPulsa = 250000;
    int GajiPokok = 0;
    int Absensi = 20;

    public abstract void tambahAbsensi ();
    abstract int getID();
    abstract String getNama();
    abstract int getAbsensi();
    
}