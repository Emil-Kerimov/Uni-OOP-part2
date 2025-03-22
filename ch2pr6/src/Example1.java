import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Example1 {
    public static void main(String[] args) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.dat"))){
            Person person = new Person("Sam", 11, 180, true);
            objectOutputStream.writeObject(person);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
class Person implements Serializable {
    private String name;
    private int age;
    private transient double height;
    private transient boolean married;

    public Person(String name, int age, double height, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public boolean isMarried() {
        return married;
    }
}