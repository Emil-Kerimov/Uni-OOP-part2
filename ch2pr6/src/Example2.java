import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Example2 {
    public static void main(String[] args){
        try (ObjectInputStream objectInputStream= new ObjectInputStream(new FileInputStream("person.dat"))){
            Person person = (Person)objectInputStream.readObject();
            System.out.printf("Name: %s\t Age: %d\n", person.getName(), person.getAge());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
