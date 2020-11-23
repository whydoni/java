public class Car {
    String merk = "Daihatsu";
    String warna = "Hitam";
    int speed = 0;
    int gear = 0;

    public void setMerk(String newValue) {
        merk = newValue;
        System.out.println("Change Merk : " +newValue);
    }

    public void setWarna(String newValue) {
        warna = newValue;
        System.out.println("Change Merk : " +newValue);
    }

    public void increaseGear() {
        gear = gear + 1;
        speed = speed + 20;
        System.out.println("Tambah Gigi jadi : " +gear + ", speed : " + speed);
    }

    public void decreaseGear() {
        gear = gear - 1;
        speed = speed - 50;
        System.out.println("Kurangi Gigi jadi : " +gear + ", speed : " + speed);
    }

    public void brakePedal(int brake) {
        speed = speed - brake;
        System.out.println("Stepped on Brake, speed : " +speed);
    }

    public void printStates() {
        System.out.println("Status Car : " +merk + ", warna : " + warna + ", speed : " +speed + ", gear : " + gear);
    }
}