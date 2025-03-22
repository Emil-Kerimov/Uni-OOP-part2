package Task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MoviesWriter {
    public static void writeToFile(List<Movie> movies, String filepath){
        try (FileWriter fileWriter = new FileWriter(filepath)){
            for (Movie movie : movies){
                fileWriter.write(String.valueOf(movie.getId()));
                fileWriter.append('\n');
                fileWriter.write(movie.getName());
                fileWriter.append('\n');
                fileWriter.write(movie.getGenre());
                fileWriter.append('\n');
            }
        } catch (IOException e){
            System.out.println("error writing file" + e.getMessage());
        }
    }
}
