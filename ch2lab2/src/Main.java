import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieManager manager = new MovieManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Initialize from з CSV");
            System.out.println("2. Read from text file");
            System.out.println("3. Deserialize");
            System.out.println("4. Search by year");
            System.out.println("5. Search by genre");
            System.out.println("6. Add movie");
            System.out.println("7. remove movie");
            System.out.println("8. exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        manager.getAllMovies().addAll(FileHandler.parse("data/movies.csv"));
                        break;
                    case 2:
                        manager.getAllMovies().addAll(FileHandler.parse("data/movies.txt"));
                        break;
                    case 3:
                        manager.getAllMovies().addAll(SerializationHandler.deserializeMovies("data/movies.dat"));
                        break;
                    case 4:
                        System.out.print("Enter year: ");
                        int year = scanner.nextInt();
                        for(Movie m : manager.searchByYear(year)) {
                        System.out.println(m.toString());
                    }
                        break;
                    case 5:
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        for(Movie m : manager.searchByGenre(genre)) {
                            System.out.println(m.toString());
                        }
                        break;
                    case 6:
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("year: ");
                        int newYear = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("genre: ");
                        String genres = scanner.nextLine();
                        manager.addMovie(name, newYear, genres);
                        break;
                    case 7:
                        System.out.println("Enter id");
                        int id = scanner.nextInt();
                        manager.removeMovie(id);
                        break;
                    case 8:
                        FileHandler.saveToTextFile(manager.getAllMovies(), "data/movies.txt");
                        SerializationHandler.serializeMovies(manager.getAllMovies(), "data/movies.dat");
                        return;
                }
            } catch (FileNotFoundException e){
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e){
                System.out.println("Cant read file " + e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("incorrect number format" + e.getMessage());
            } catch (Exception e) {
                System.out.println("unknown exception" + e.getMessage());
            }
        }
    }
}
