public class Mahasiswa {
    String name = "";
    String gender = "";
    int age = 0;

    public void setName(String newValue) {
        name = newValue;
    }

    String getName() {
        return name;
    }
    
    public void setGender(String newGender) {
        gender = newGender;
    }

    String getGender() {
        return gender;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    int getAge() {
        return age;
    }

    public void printStates() {
        System.out.println("Nama : " + getName() +
                            "\nJenis Kelamin : " + getGender() + 
                            "\nUmur : " + getAge() +"tahun");
    }
}
