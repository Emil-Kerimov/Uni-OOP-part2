import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Example7 {
    public static void main(String[] args){
        String filename = "C:\\SomeDir\\notes.txt";
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("C:\\SomeDir\\output.zip"));
             FileInputStream fis = new FileInputStream(filename);){
            ZipEntry entry1 = new ZipEntry("notes.txt");
            zipOutputStream.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zipOutputStream.write(buffer);
            zipOutputStream.closeEntry();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
