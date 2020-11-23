public class CommandVolumeArray {
    public static void main(String[] args) {
        int type = Integer.parseInt(args[0]);
        if (type == 1 ) {
            System.out.println(Volume(Integer.parseInt(args[1])));
        } else if (type == 2) {
            System.out.println(Volume(Double.parseDouble(args[1])));
        } else if (type == 3) {
            int column = Integer.parseInt(args[1]);
            if (column == 2) {
                String[][] arr = {
                    {"satu", "dua", "tiga", "empat"},
                    {"lima", "enam", "tujuh", "delapan"}
                };
                for (int i = 0; i<2 ; i++) {
                    for (int j=0; j<arr[i].length; j++) {
                        System.out.print(arr[i][j] + ", ");

                    };
                    System.out.println();
                };
            } else if (column == 3) {
                String[][] arr = {
                    {"satu", "dua", "tiga", "empat"},
                    {"lima", "enam", "tujuh", "delapan"},
                    {"sembilan", "sepuluh"}
                };
                for (int i = 0; i<3 ; i++) {
                    for (int j=0; j<arr[i].length; j++) {
                        System.out.print(arr[i][j] + ", ");
                    };
                    System.out.println();
                };
            }
        //    String[][] arr = new String[2][4];
        //    arr[0] = new String[4];
        //    arr[1] = new String[4];
        //    arr[0][] = {"satu"; "dua"; "tiga"; "empat"};
        //    arr[1][] = {"lima"; "enam"; "tujuh"; "delapan"};
        //    System.out.println(arr[0]);
        // } 
        // else if (type == 3) {
        //     System.out.println(Luas(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
        // } 
        // else if (type == 4) {
        //     System.out.println(Umur(2020, Integer.parseInt(args[3])));
        } else {
            System.out.println("Commandline salah input");
        }
    }

    public static int Volume(int s) {
        return s * s * s;
    }
    
    public static double Volume(double r) {
        return r*r*r*(4/3)*(22/7);
    }
    // public static float Luas(int a, int b) {
    //     return a*b/2;
    // }
    // public static int Umur(int thisYear, int year) {
    //     return thisYear - year;
    // }

}