import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String text =  "Hello world!";
        try(FileOutputStream fos = new FileOutputStream("notes.txt")){
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("The File has been written");
    }
}