import java.util.List;

public class MultiThread1 extends Thread {
    List<Integer> data;
    public MultiThread1(List<Integer> data) {
        this.data = data;
    }
    public void run() {
        for (int number: data) {
            System.out.println(number);
        }
    }  
}