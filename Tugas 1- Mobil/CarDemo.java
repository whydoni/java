public class CarDemo {
    public static void main(String[] args) {
        
        Car car1 = new Car();
        Car car2 = new Car();

        car1.setMerk("Porsche");
        car1.setWarna("Ungu");
        car1.increaseGear();
        car1.increaseGear();
        car1.increaseGear();
        car1.increaseGear();
        car1.brakePedal(30);
        car1.increaseGear();
        car1.increaseGear();
        car1.decreaseGear();
        car1.printStates();

        car2.setMerk("BMW");
        car2.setWarna("Putih");
        car2.increaseGear();
        car2.increaseGear();
        car2.increaseGear();
        car2.increaseGear();
        car2.increaseGear();
        car2.increaseGear();
        car2.decreaseGear();
        car2.decreaseGear();
        car2.printStates();
    }
}