package Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoviesParser {
    public static List<Movie> parse(String filename){
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                List<String> fields = parseCSVLine(line);
                if (fields.size() < 3) continue; // Проверяем, что данных достаточно
                int movieID = Integer.parseInt(fields.get(0));
                String name = fields.get(1);
                String genre = fields.get(2);
                movies.add(new Movie(movieID, name, genre));
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения CSV: " + e.getMessage());
        }
        return movies;
    }

    public static List<String> parseCSVLine(String line){
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();

        for (char c : line.toCharArray()){
            if (c == '\"') {
                inQuotes = !inQuotes;  // Переключаем режим кавычек
            } else if (c == ',' && !inQuotes) {
                result.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        result.add(sb.toString().trim());

        // Удаление лишних кавычек у названия
        if (result.size() > 1) {
            result.set(1, result.get(1).replaceAll("^\"|\"$", ""));
        }

        return result;
    }
}
