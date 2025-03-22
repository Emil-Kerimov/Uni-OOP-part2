import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        try(PrintStream printStream = new PrintStream("notes3.txt")){
            printStream.print("Hello world!");
            printStream.println("Welcome to Java!");
            printStream.printf("Name: %s Age: %d \n", "Tom", 34);
            String msg = "PrintStream";
            byte[] msg_toBytes = msg.getBytes();
            printStream.write(msg_toBytes);
            System.out.println("The file has been written");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}