public class KaryawanDemo { //inisiasi class KaryawanDemo dengan modifier public
    public static void main(String[] args) {
        //membuat tiga objek karyawan k1, k2, dan k3
        Karyawan k1 = new Karyawan();
        Karyawan k2 = new Karyawan();
        Karyawan k3 = new Karyawan();

        k1.setNama("Doni Wahyudi"); //men-set nama Doni Wahyudi
        k1.setJabatan("Manager"); //men-set jabatan Manager
        k1.setGaji(10000000); //men-set gaji 10.000.000
        k1.printKaryawan(); //mengeprint nilai dari nama, jabatan, dan gaji k1

        k2.setNama("Andi Gilang"); //men-set nama Andi Gilang
        k2.setJabatan("Supervisor"); //men-set jabatan Supervisor
        k2.setGaji(7000000); //men-set gaji 7.000.000
        k2.printKaryawan(); //mengeprint nilai dari nama, jabatan, dan gaji k2

        k3.setNama("Reza Fadhilah"); //men-set nama Reza Fadhilah
        k3.setJabatan("Staff"); //men-set jabatan Staff
        k3.setGaji(5000000); //men-set gaji 5.000.000
        k3.printKaryawan(); //mengeprint nilai dari nama, jabatan, dan gaji k3

    }
}
