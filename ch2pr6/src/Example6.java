import java.io.File;
import java.io.IOException;

public class Example6 {
    public static void main(String[] args){
        File myFile = new File("C://SomeDir//notes.txt");
        System.out.println("File name: " + myFile.getName());
        System.out.println("Parent Folder: " + myFile.getParent());
        if (myFile.exists())
            System.out.println("File exists");
        else
            System.out.println("File not found");
        System.out.println("File size: " + myFile.length());
        if(myFile.canRead())
            System.out.println("File can be read");
        else
            System.out.println("File cant be read");
        if (myFile.canWrite())
            System.out.println("File can be written");
        else
            System.out.println("File cant be written");
        File newFile = new File("C://SomeDir//MyFile");
        try {
            boolean created = newFile.createNewFile();
            if (created)
                System.out.println("File has been created");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
