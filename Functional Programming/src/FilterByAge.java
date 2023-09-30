import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static class Person{
        String name;
        int age;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();
        while (n-->0){
            String[] data = scan.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person();
            person.age = age;
            person.name = name;
            people.add(person);
        }
        String condition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Person> filter = createFilter(condition,age);
        // we need it to make a clear version of filter

        Consumer<Person> printer = createPrinter(format);
        // we need it to print them in our own way

        people.stream()
                .filter(filter)
                .forEach(printer);

    }

    private static Consumer<Person> createPrinter(String format) {
        if(format.equals("name")){
            return p-> System.out.println(p.name);
        }else if (format.equals("age")){
            return p-> System.out.println(p.age);
        }else{
            return p-> System.out.println(p.name+ " - " + p.age);
        }
    }

    private static Predicate<Person> createFilter(String condition, int age) {
        if(condition.equals("younger")){
            return p->p.age<=age;
        }
        return p->p.age>=age;
    }
}
