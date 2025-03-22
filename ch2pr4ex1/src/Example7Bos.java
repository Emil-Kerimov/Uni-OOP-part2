import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example7Bos {
    public static void main(String[] args){
        String text = "Hello world!!";
        try(FileOutputStream out = new FileOutputStream("notes.txt");
            BufferedOutputStream bos = new BufferedOutputStream(out)){
            byte[] buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
