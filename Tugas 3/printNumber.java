import java.util.List;

public class printNumber extends Thread {
    List<Integer> listnumber;
    public printNumber(List<Integer> listnumber) {
        this.listnumber = listnumber;
    }
    public void run() {
		for (int obj : listnumber) {
            System.out.println(obj);
        }
        
    } 
}