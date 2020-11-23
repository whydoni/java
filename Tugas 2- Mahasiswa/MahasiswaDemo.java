public class MahasiswaDemo {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa();
        Mahasiswa m2 = new Mahasiswa();

        m1.setName("Si Al");
        m1.setGender("Laki-laki");
        m1.setAge(22);
        m1.printStates();

        m2.setName("Si Dul");
        m2.setGender("Laki-laki");
        m2.setAge(30);
        m2.printStates();
    }
}
