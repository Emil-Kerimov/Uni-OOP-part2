import java.io.*;

public class Example6 {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("notes5.txt"))){
            String text;
            while (!(text = br.readLine()).equals("ESC")){
                bw.write(text + "\n");
                bw.flush();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
