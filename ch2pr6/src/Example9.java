import java.io.IOException;
import java.io.RandomAccessFile;

public class Example9 {
    public static void main (String [] args) {
        try {
            String fPath = "source.txt";
            String s = new String (readCharsFromFile(fPath,1,5));
            System.out.println(s);
            writeData(fPath,
                    "Data"
                    , 5);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
    private static void writeData (String filePath, String data,
                                   int seek) throws IOException {
        RandomAccessFile file = new RandomAccessFile (filePath, "rw");
        // go to index
        file.seek(seek);
        file.write(data.getBytes());
        file.close();
    }
    private static byte [] readCharsFromFile (String fPath, int
            seek, int chars) throws IOException {
        RandomAccessFile file = new RandomAccessFile(fPath, "r");
        file.seek(seek);
        byte[] bytes = new byte[chars];
        file.read(bytes);
        file.close();
        return bytes;
    }
}
