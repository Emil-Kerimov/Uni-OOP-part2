package Task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipExtractor {
    public static void extract(String archivePath, String outFilepath){
        File outDir = new File(outFilepath);

        if(!outDir.exists()){
            outDir.mkdirs();
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archivePath))){
            ZipEntry entry;
            byte[] buffer = new byte[4096];

            while ((entry = zipInputStream.getNextEntry()) != null){
                File outFile = new File(outDir, entry.getName());

                try (FileOutputStream fileOutputStream = new FileOutputStream(outFile)){
                    int len;
                    while ((len = zipInputStream.read(buffer)) > 0){
                        fileOutputStream.write(buffer, 0, len);
                    }
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
                zipInputStream.closeEntry();
            }
        } catch (IOException e){
            System.out.println("Cant extract from archive " + e.getMessage());
        }
    }
}
