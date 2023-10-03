package Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();
        while (times-->0){
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name,age);
            people.add(person);
        }
        Comparator<Person> sort = (p1,p2)->p1.name.compareTo(p2.name);
        Predicate<Person> filter = person->person.age>30;
        Consumer<Person> printer = person-> System.out.println(person.getName() + " - " + person.getAge());

        people.stream()
                .filter(filter)
                .sorted(sort)
                .forEach(printer);

    }
}
