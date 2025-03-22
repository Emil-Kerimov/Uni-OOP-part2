import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example2FIS {
    public static void main(String[] args){
      try(FileInputStream fis = new FileInputStream("notes.txt");
          FileOutputStream fos = new FileOutputStream("new_notes.txt")) {
          byte[] buffer = new byte[fis.available()];
          fis.read(buffer, 0, fis.available());
          fos.write(buffer, 0, buffer.length);
      } catch (IOException e){
          System.out.println(e.getMessage());
      }
    }
}
