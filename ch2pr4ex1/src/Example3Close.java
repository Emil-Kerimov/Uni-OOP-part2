import java.io.FileInputStream;
import java.io.IOException;

public class Example3Close {
    public static void main(String[] args){
        try (FileInputStream fis = new FileInputStream("notes.txt")) {
            int i = -1;
            while ((i = fis.read()) != -1){
                System.out.print((char) i);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}