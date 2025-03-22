import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieManager {
    private ArrayList<Movie> movies = new ArrayList<>();
    public void addMovie(String name, int year, String genres){
        int movieID = movies.isEmpty() ? 1  : ((movies.get(movies.size()-1).getId())+1);
        movies.add(new Movie(movieID, name, year, genres));
    }
    public void removeMovie(int id){
        movies.removeIf(f -> f.getId() == id);
    }
    public List<Movie> searchByYear(int year){
        return movies.stream().filter(f -> f.getYear() == year).collect(Collectors.toList());
    }
    public List<Movie> searchByGenre(String genre){
        return movies.stream().filter(f -> f.getGenre().contains(genre)).collect(Collectors.toList());
    }
    public List<Movie> getAllMovies(){
        return movies;
    }
}
