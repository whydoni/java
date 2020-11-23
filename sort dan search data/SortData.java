import java.util.*;
public class SortData {
    public static void main(String[] args) {
        // ArrayList<Integer> inputData = new ArrayList<>();
        // for(int i = 0; i<args.length; i++) {
        //     inputData.add(Integer.parseInt(args[i]));
        // };
        int[] inputData = new int[args.length]; //membuat variabel inputData untuk menampung args sesuai dengan jumlah args yg diinput
        for(int i = 0; i<args.length; i++) { //looping args sejumlah panjang args yang diinput
            int newArgs = Integer.parseInt(args[i]); //deklarasi variabel newArgs untuk menyimpan sementara args yang telah dikonversi menjadi integer
            inputData[i] = newArgs; //memasukkan integer args ke dalam variabel inputData
        };

        System.out.print("Data yang di input : ");
        for (int data : inputData) { //melooping item data di dalam inputData
            System.out.print(data + ", "); //print data satu persatu secara horizontal
        };
        System.out.println("");

        int[] sort = bubbleSort(inputData); //membuat variabel sort yang berisikan items di inputData yang telah di sort dengan bubbleSort
        System.out.print("Data setelah di sortir : ");
        for (int data : sort) { //melooping item data di dalam variabel sort
            System.out.print(data + ", "); //print data satu persatu secara horizontal
        };
        System.out.println("");

        System.out.print("Data ditemukan : ");
        binarySearch(inputData); //menggunakan method binarySearch untuk mencari data dengan value 23 di dalam variabel inputData
    }

    public static int[] bubbleSort(int[] datas){ //deklarasi method bubbleSort dengan return array integer dan input array integer dari datas
        for (int i=0;i<datas.length-1;i++){ //looping datas sejumlah panjang datas yang diinput dikurangi 1
            for(int j=0;j<datas.length-1-i;j++){ //looping datas sejumlah panjang datas yang diinput dikurangi 1 dan nilai i
                if(datas[j+1]<datas[j]){//memfilter data untuk data yang lebih besar setelah data tersebut agar tersortir dari kecil ke besar
                    int data1 = datas[j];//menampung data awal pada variabel data1
                    datas[j]=datas[j+1];//menukar data pada index j dengan data setelahnya
                    datas[j+1]= data1;//memindahkan nilai data1 ke data pada index j + 1
                }
            }
        }
        return datas;//mereturn datas yang telah tersortir
    }

    public static void binarySearch(int[] datas){ //deklarasi method binarySearch tanpa return dengan input array integer
        int target = 23; //mendefinisikan nilai dari data yang dicari
        int left = 0; //membuat variabel left untuk menjadi index pada data paling kiri untuk klaster data yang akan di search
        int middle; //membuat variabel middle untuk menjadi patokan saat melakukan looping search
        int right = datas.length - 1; //membuat variabel left untuk menjadi index pada data paling kanan untuk klaster data yang akan di search
        while (left <= right) { //looping ketika nilai variabel left lebih kecil sama dengan right
            middle = (left + right) / 2; //men-set index variabel middle untuk menjadi data tengah antara lef dan right
            if (datas[middle] == target) {//mengecek apakah nilai dari array dengan index middle sama dengan nilai data yang dicari
                System.out.println("23 found at index " + middle);//mengeprint index data jika ditemukan di index middle
                break;
            } else if (datas[middle] < target) { //mengecek apakah nilai dari array dengan index middle kurang dari nilai data yang dicari
                left = middle + 1;//men-set nilai left dengan nilai middle + 1 untuk melanjutkan search ke data sebelah kanan dari partisi data
            } else if (datas[middle] > target) {//mengecek apakah nilai dari array dengan index middle lebih dari nilai data yang dicari
                right = middle - 1;//men-set nilai right dengan nilai middle + 1 untuk melanjutkan search ke data sebelah kiri dari partisi data
            }
        }
    }
}