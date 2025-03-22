import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example5Baos {
    public static void main(String[] args){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String text = "Hello world!";
        byte[] buffer = text.getBytes();
        try {
            baos.write(buffer);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try (FileOutputStream fos = new FileOutputStream("hello.txt")){
            baos.writeTo(fos);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
