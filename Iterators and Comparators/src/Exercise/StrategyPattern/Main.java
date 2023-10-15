package Exercise.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Person> first = new TreeSet<>(new NameComparator());
        Set<Person> second = new TreeSet<>(new AgeComparator());

        int times = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < times; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            first.add(new Person(tokens[0],Integer.parseInt(tokens[1])));
            second.add(new Person(tokens[0],Integer.parseInt(tokens[1])));
        }
        printMethod(first);
        printMethod(second);
    }

    private static void printMethod(Set<Person> set) {
        set.forEach(System.out::println);
    }
}
