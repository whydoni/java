import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AscendingThread extends Thread {
    List<Integer> data;
    public AscendingThread(List<Integer> data) {
        this.data = data;
    }
    public void run() {
		try {
            FileWriter writer = new FileWriter("fileDataAsc.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            bubbleSortAsc(data);
            for (int number: data) {
                buffer.write(Integer.toString(number));
                buffer.write("\n");
            }
            buffer.close();
            writer.close();
        System.out.println("Sorted Ascending Done!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    } 
    public static void bubbleSortAsc(List<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < list.size() - 1; j++)
            {
                if (list.get(j).compareTo(list.get(j + 1)) > 0)
                {
                    Collections.swap(list, j, j + 1);
                }
            }
    }
}