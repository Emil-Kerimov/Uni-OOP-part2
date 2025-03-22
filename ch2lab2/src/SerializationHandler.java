import java.io.*;
import java.util.List;

public class SerializationHandler {
    public static void serializeMovies(List<Movie> movies, String filepath) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath))){
            objectOutputStream.writeObject(movies);
        }
    }
    public static List<Movie> deserializeMovies(String filepath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filepath))){
            return (List<Movie>) objectInputStream.readObject();
        }
    }
}
