import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Example8 {
    public static void main(String[] args){
        try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("C:\\SomeDir\\output.zip"))){
            ZipEntry entry;
            String name;
            long size;
            while ((entry=zipInputStream.getNextEntry()) != null){
                name = entry.getName();
                size = entry.getSize();
                System.out.printf("File name:%s\t File size:%d\n" ,name, size);
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\somedir\\new" + name);
                for (int c = zipInputStream.read(); c != -1; c = zipInputStream.read()){
                    fileOutputStream.write(c);
                }
                fileOutputStream.flush();
                zipInputStream.closeEntry();
                fileOutputStream.close();
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
