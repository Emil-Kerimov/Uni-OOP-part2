import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String name;
    private int year;
    private String genre;

    public Movie(int id,  String name, int year, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    @Override
    public String toString() {
        return id + "," + name + " (" + year + ")," + genre;
    }
}
