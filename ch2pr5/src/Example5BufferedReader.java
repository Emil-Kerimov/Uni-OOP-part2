import java.io.*;

public class Example5BufferedReader {
    public static void main(String[] args){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("notes4.txt"))){
            // reading character by character
            String s;
            while ((s = bufferedReader.readLine()) != null){
                System.out.println(s);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
