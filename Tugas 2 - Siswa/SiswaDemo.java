public class SiswaDemo { //inisialisasi class SiswaDemo
    public static void main(String[] args) {
        Siswa siswa1 = new Siswa("Si Dul", 74, "Laki-laki", 20, 5, 1998); //membuat objek siswa1
        siswa1.printSiswa(); //mengeprint nama, nilai, dan gender
        System.out.println("Tanggal Lahir : " + siswa1.convertBulan()); //mengeprint tanggal lahir yang telah disesuaikan format bulannya menjadi string
        System.out.println("Umur : " + siswa1.getUmur()); //mengeprint umur dari method getUmur
        System.out.println("Grade : " + siswa1.index()); //mengeprint grade nilai
        System.out.println("Kelas : " + siswa1.kelas(siswa1.getUmur())); //mengeprint tingkatan kelas yang telah difilter dari method kelas
        System.out.println("History : " );
        siswa1.historyUmur(siswa1.getYear()); //mengeprint looping-an jejak umur dari lahir hingga tahun ini
    }
}