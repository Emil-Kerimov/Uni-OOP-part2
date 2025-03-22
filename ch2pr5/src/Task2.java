import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args){
        try (DataInputStream dis = new DataInputStream(new FileInputStream("movies.zip"))){

            dis.skipBytes(4);
            short version = dis.readShort();
            version = Short.reverseBytes(version);
            System.out.println("version " + version);

            dis.skipBytes(4);

            short lastModificationTime = dis.readShort();
            lastModificationTime = Short.reverseBytes(lastModificationTime);
            int hour = (lastModificationTime >> 11) & 0x1F;
            int minutes = (lastModificationTime >> 5) & 0x3F;
            int seconds = (lastModificationTime & 0x1F) * 2;
            System.out.println("Modification Time: " + hour +":" +minutes+ ":" + seconds);


            short lastModificationData = dis.readShort();
            lastModificationData = Short.reverseBytes(lastModificationData);
            int years = ((lastModificationData >> 9) & 0x7F) + 1980;
            int months = ((lastModificationData >> 5) & 0x0F);
            int days = lastModificationData & 0x1F;
            System.out.println("Modification Data(DD:MM:YYYY): " + days + ":" +months+ ":" +  years);


            dis.skipBytes(4);

            int compressedSize = dis.readInt();
            compressedSize = Integer.reverseBytes(compressedSize);
            System.out.println("compressedSize (bytes): " + compressedSize);

            int unCompressedSize = dis.readInt();
            unCompressedSize = Integer.reverseBytes(unCompressedSize);
            System.out.println("unCompressedSize (bytes): " + unCompressedSize);

            short fileNameLength = dis.readShort();
            dis.skipBytes(2);
            byte[] b = new byte[Short.reverseBytes(fileNameLength)];
            dis.readFully(b);
            String fileName = new String(b);
            System.out.println("filename: " + fileName);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
