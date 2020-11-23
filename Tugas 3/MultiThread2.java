import java.util.List;

public class MultiThread2 extends Thread {
    List<Integer> data;
    public MultiThread2(List<Integer> data) {
        this.data = data;
    }
    public void run() {
        for (int number: data) {
            System.out.println(number);
        }
    }  
}