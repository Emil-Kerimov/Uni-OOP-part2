import java.io.*;

public class Task2 {
    public static void main(String[] args){
        String src = "note.txt";
        String dest1 = "new_note_byte.txt";
        String dest2 = "new_note_Buffered.txt";
        long byByteTime = copyFileByByte(src, dest1);
        System.out.println("estimated time copy by byte : " + byByteTime + " ms ");
        long bufferedCopy = copyFileBuffered(src, dest2);
        System.out.println("estimated time copyFileBuffered : " + bufferedCopy + " ms ");
        System.out.println("Speedup " + (byByteTime/bufferedCopy));
    }

    public static long copyFileByByte(String src, String dest){
        long startTime = System.currentTimeMillis();
        try(FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest)){
            int byteRead;
            while ((byteRead = fis.read()) != -1){
                fos.write(byteRead);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return  System.currentTimeMillis() - startTime;
    }

    public static long copyFileBuffered(String src, String dest){
        long startTime = System.currentTimeMillis();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))){
            byte[] buffer = new  byte[16384];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1){
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return  System.currentTimeMillis() - startTime;
    }
}
