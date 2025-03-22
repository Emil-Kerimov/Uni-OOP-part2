import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Example5BufferedWriter {
    public static void main(String[] args){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("notes4.txt"))){
            String text = "Hello world! And something else";
            bufferedWriter.write(text);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
