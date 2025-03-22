package Task2;

import java.util.List;

public class Main {
    public static void main(String[] args){
        ZipExtractor.extract("movies.zip", "C://Study");
        List<Movie> movies = MoviesParser.parse("C://Study//movies.csv");
        MoviesWriter.writeToFile(movies, "movies.txt");
    }
}
