import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThreadDemo {
    public static Scanner keyboard = new Scanner(System.in);
    public static String filename;
    public static int jumworker;
    public static List<Integer> data = new ArrayList<Integer>();
    public static void main(String[] args) {
        filename=args[0];
        jumworker=Integer.parseInt(args[1]);
        movetoList();
        menu();
    }
    public static void menu(){
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Print Multi Thread\n2. Print Thread Pool\n3. Thread Print, Thread Read ASC & DESC\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            switch (keyInput) {
                case 1:
                    System.out.println("Multi Thread");
                    clearScreen();
                    MultiThread();
                    pressAnyKeyToContinue();
                    break;
                case 2:
                    System.out.println("Thread Pool");
                    clearScreen();
                    threadPool(jumworker);
                    pressAnyKeyToContinue();
                    break;
                case 3:
                    clearScreen();
                    System.out.println("Print ASC DESC");
                    AscendingThread m1=new AscendingThread(data);  
                    DescendingThread m2=new DescendingThread(data);
                    printNumber m3=new printNumber(data);
                    m1.start();  
                    m2.start();  
                    m3.start();
                    pressAnyKeyToContinue();
                    break;
                default:
                    break;
            }
        } while (keyInput != 0);
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    public static void pressAnyKeyToContinue()
    { 
           System.out.println("Press Enter key to continue...");
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }
    public static void threadPool(int jumworker){
        ExecutorService executor = Executors.newFixedThreadPool(jumworker);       
        for (int i: data){
            Runnable worker = new ThreadPool(String.format(""+ i));
            executor.execute(worker);//calling execute method of ExecutorService  
        }
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
 
       System.out.println("Finished all threads");  
    }

    public static void movetoList(){
        String textfile = "";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int i;
            while ((i = br.read()) != -1) {

                textfile += (char) i;
            }
            fr.close();
            br.close();
            String[] values = textfile.split(",");
            for (String obj: values) {
                data.add(Integer.parseInt(obj));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void MultiThread(){
        List<Integer> thread1 = data.subList(0, 25);
        List<Integer> thread2 = data.subList(25, 50);
        List<Integer> thread3 = data.subList(50, 75);
        List<Integer> thread4 = data.subList(75,100);
            
        MultiThread1 m1=new MultiThread1(thread1);
        MultiThread2 m2=new MultiThread2(thread2);  
        MultiThread3 m3=new MultiThread3(thread3);  
        MultiThread4 m4=new MultiThread4(thread4);  
        m1.start();  
        m2.start();  
        m3.start();  
        m4.start();  
    }
}
