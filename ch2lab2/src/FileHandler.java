import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static List<Movie> parse(String filename){
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                List<String> fields = parseCSVLine(line);
                if (fields.size() < 4) continue;
                int movieID = Integer.parseInt(fields.get(0));
                String name = fields.get(1);
                int year = Integer.parseInt(fields.get(2));
                String genre = fields.get(3);
                movies.add(new Movie(movieID, name, year, genre));
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
        return movies;
    }

    public static List<String> parseCSVLine(String line){
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();

        for (char c : line.toCharArray()){
            if (c == '\"') {
                inQuotes = !inQuotes;
            }
            else if (c == ',' && !inQuotes) {
                result.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        result.add(sb.toString().trim());

        if (result.size() > 1) {
            String nameWithYear = result.get(1).replaceAll("^\"|\"$", "").replace("\u00A0", " ");

            String year = "";
            String name = nameWithYear;

            if (nameWithYear.matches(".*\\(\\d{4}\\)$")) {
                year = nameWithYear.replaceAll(".*\\((\\d{4})\\)$", "$1");
                name = nameWithYear.replaceAll("\\(\\d{4}\\)$", "").trim();  // remove year
            } else {
                year = "0";
            }
            result.set(1, name);
            result.add(2, year);
        }
        return result;
    }

    public static void saveToTextFile(List<Movie> movies,String filepath) throws IOException{
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath))){
            for (Movie movie : movies){
                bufferedWriter.write(movie.toString());
                bufferedWriter.newLine();
            }
        }
    }
}
