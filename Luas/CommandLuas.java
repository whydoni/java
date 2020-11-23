public class CommandLuas {
    public static void main(String[] args) {
        int type = Integer.parseInt(args[0]);
        if (type == 1 ) {
            System.out.println(Luas(Integer.parseInt(args[1])));
        } else if (type == 2) {
            System.out.println(Luas(Double.parseDouble(args[1])));
        } else if (type == 3) {
            System.out.println(Luas(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
        } else if (type == 4) {
            System.out.println(Umur(2020, Integer.parseInt(args[3])));
        } else {
            System.out.println("Commandline salah input");
        }
    }

    public static int Luas(int s) {
        return s * s;
    }
    
    public static double Luas(double r) {
        return r*r*22/7;
    }
    public static float Luas(int a, int b) {
        return a*b/2;
    }
    public static int Umur(int thisYear, int year) {
        return thisYear - year;
    }

}