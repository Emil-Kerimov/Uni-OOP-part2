import java.io.File;

public class Example4 {
    public static void main(String[] args){
        // define an object for the directory
        File dir = new File("C://SomeDir");

        if (dir.isDirectory()){
            // get all nested objects in the directory
            for (File item : dir.listFiles()){
                if (dir.isDirectory()){
                    System.out.println(item.getName() + "\t folder");
                }
                else {
                    System.out.println(item.getName() + "\t file");
                }
            }
        }
    }
}
