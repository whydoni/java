public class Siswa { //inisialisasi class Siswa
    //deklarasi objek nama, nilai, gender dan tanggal lahir sebagai instance variabel
    private String nama = "";
    private int nilai = 0;
    private String gender = "";
    private int hariLahir = 0;
    private int bulanLahir = 0;
    private int tahunLahir = 0;
    
    //initial value thisYear dan umur
    int thisYear = 2020;
    int umur = 0;

    //deklarasi method siswa yang menerima parameter inputan nama, nilai, gender, dan tanggal lahir
    public Siswa(String inputNama, int inputNilai, String inputGender, int day, int month, int year) {
        this.nama = inputNama;
        this.nilai = inputNilai;
        this.gender = inputGender;
        this.hariLahir = day;
        this.bulanLahir = month;
        this.tahunLahir = year;
    }
    
    //deklarasi method index untuk mendapatkan return grade berdasarkan nilai
    public String index() {
        String grade;
        if (nilai >=80) {
            return grade = "A";
        } else if (nilai >=70) {
            return grade = "B";
        } else if (nilai >=60) {
            return grade = "C";
        } else {
            return grade = "D";
        }
    }

    //deklarasi method kelas berdasarkan umur
    public String kelas(int umur) {
        String kelas;
        if(umur >=24) {
            return kelas = "Sudah Kerja";
        } else if (umur >= 19) {
            return kelas = "Sedang Kuliah";
        } else {
            return kelas = "Masih SMA";
        }
    }

    //method untuk menghitung dan mereturn umur
    public int getUmur() {
        int newUmur = thisYear - tahunLahir;
        this.umur = newUmur;
        return this.umur;
    }

    //method untuk mengubah bulan lahir dari bentuk integer menjadi string
    public String convertBulan() {
        String newMonth;
        switch (bulanLahir) {
            case 1:  newMonth = "Januari";
                     break;
            case 2:  newMonth = "Februari";
                     break;
            case 3:  newMonth = "Maret";
                     break;
            case 4:  newMonth = "April";
                     break;
            case 5:  newMonth = "Mei";
                     break;
            case 6:  newMonth = "Juni";
                     break;
            case 7:  newMonth = "Juli";
                     break;
            case 8:  newMonth = "Agustus";
                     break;
            case 9:  newMonth = "September";
                     break;
            case 10: newMonth = "Oktober";
                     break;
            case 11: newMonth = "November";
                     break;
            case 12: newMonth = "Desember";
                     break;
            default: newMonth = "Invalid month";
                     break;
        }
        //untuk mereturn menjadi format tanggal bulan dan tahun lahir
        String retString = "" + hariLahir + " " + newMonth + " " + tahunLahir;
        
        return retString;
    }

    //method untuk mengambil tahun lahir untuk kemudian dimasukkan menjadi parameter di method historyUmur
    public int getYear() {
        return tahunLahir;
    }

    //method untuk me-looping umur dari lahir hingga tahun ini
    public void historyUmur(int tahunLahir){
        String history;
        int countUmur = 0;
        for(int i=tahunLahir; i<thisYear+1; i++){
            history = ("Tahun "+(i) + ", Umur : " + countUmur+"\n");
            countUmur++;
            System.out.print(history);
        }
    }
    
    //method untuk mengeprint data nama, nilai, dan gender
    public void printSiswa() {
        System.out.println("Nama : " + nama +
        "\nNilai : " + nilai +
        "\nGender : " + gender);
    }
    
}