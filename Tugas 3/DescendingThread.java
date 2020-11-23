import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DescendingThread extends Thread {
    List<Integer> data;
    public DescendingThread(List<Integer> data) {
        this.data = data;
    }
 
    public void run() {
        try {
            FileWriter writer = new FileWriter("fileDataDesc.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            Integer[] intArray = bubbleSort(data);
            for (int number: intArray) {
                buffer.write(Integer.toString(number));
                buffer.write("\n");
            }
            buffer.close();
            writer.close();
        System.out.println("Sorted  Ascending Done!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  

    private static Integer[] bubbleSort(List<Integer> list) {
        Integer[] intArray = list.toArray(new Integer[0]);

        int n = intArray.length;
        int temp = 0;
        
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(intArray[j-1] < intArray[j]){
                    temp = intArray[j-1];
                    intArray[j-1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
        return intArray;
    }
}