import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

public class Example6Bis {
    public static void main(String[] args){
        String text = "Hello world!";
        byte[] buffer = text.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buffer);
        try (BufferedInputStream bis = new BufferedInputStream(in)){
            int c;
            while ((c = bis.read()) != -1){
                System.out.println((char) c);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
