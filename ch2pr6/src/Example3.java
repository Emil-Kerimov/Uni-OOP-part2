import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Example3 {
    public static void main(String[] args){
        String filename = "people.dat";
        ArrayList <Person> people = new ArrayList<Person>();
        people.add(new Person("Tom", 22, 179, false));
        people.add(new Person("Sam", 33, 177, true));
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))){
            objectOutputStream.writeObject(people);
            System.out.println("File has been written");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        ArrayList<Person> newPeople = new ArrayList<Person>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))){
            newPeople = ((ArrayList<Person>) objectInputStream.readObject());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        for(Person p : newPeople){
            System.out.printf("Name: %s\t Age: %d\n",p.getName(),p.getAge());
        }
    }
}
