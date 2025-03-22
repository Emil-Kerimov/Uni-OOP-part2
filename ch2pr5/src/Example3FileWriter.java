import java.io.FileWriter;
import java.io.IOException;

public class Example3FileWriter {
    public static void main(String[] args){
        try (FileWriter fileWriter = new FileWriter("notes3.txt", false)){
            String text = "Hello world!";
            fileWriter.write(text);

            fileWriter.append('\n');
            fileWriter.append('E');
            fileWriter.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
