package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int desiredLength = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");

        Predicate<String> checker = eachName -> eachName.length()<=desiredLength;
        Arrays.stream(names)
                .filter(checker)
                .forEach(System.out::println);
    }
}
