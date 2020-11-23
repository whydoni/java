public class Karyawan { //inisiasi class Karyawan dengan modifier public
    String nama = ""; //deklarasi state nama dengan initial value kosong
    String jabatan = ""; //deklarasi state jabatan
    int gaji = 0; //deklarasi state gaji

    public void setNama(String newNama) { //deklarasi behaviour setNama tanpa return dengan parameter string
        nama = newNama; //deklarasi ulang nilai state nama dengan nilai dari parameter
    }

    String getNama() { //deklarasi behaviour getNama dengan return nama berupa string
        return nama;
    }
    public void setJabatan(String newJabatan) { //deklarasi behaviour setJabatan tanpa return dengan parameter string
        jabatan = newJabatan; //deklarasi ulang nilai state jabatan dengan nilai dari parameter
    }

    String getJabatan() { //deklarasi behaviour getJabatan dengan return jabatan berupa string
        return jabatan;
    }
    public void setGaji(int newGaji) { //deklarasi behaviour setGaji tanpa return dengan parameter integer
        gaji = newGaji; //deklarasi ulang nilai state jabatan dengan nilai dari parameter
    }

    int getGaji() { //deklarasi behaviour getGaji dengan return gaji berupa integer
        return gaji;
    }

    public void printKaryawan() { //deklarasi behaviour printKaryawan yang akan mem-print return dari method/behaviour getNama, getJabatan, dan getGaji
        System.out.println("Nama : " + getNama() +
                            "\nJabatan : " + getJabatan() + 
                            "\nGaji : " + getGaji() +"\n");
    }
}