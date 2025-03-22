import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Example4FileReader {
    public static void main(String[] args){
        try (FileReader fileReader = new FileReader("notes3.txt")){
            char[] buf = new char[256];
            int c;
            while ((c = fileReader.read(buf)) > 0){
                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
