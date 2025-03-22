import java.io.File;

public class Example5 {
    public static void main(String[] args){
        File dir = new File("C://SomeDir//NewDir");
        boolean created = dir.mkdir();
        if(created)
            System.out.println("Folder has been created");
        // Rename the directory
        File newDir = new File("C://SomeDir//NewDirRenamed");
        dir.renameTo(newDir);
        // delete the directory
        boolean deleated = newDir.delete();
        if (deleated)
            System.out.println("Folder has been deleted");
    }
}
