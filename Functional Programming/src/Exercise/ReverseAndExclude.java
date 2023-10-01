package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> collection = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int numberToDivide = Integer.parseInt(scan.nextLine());

        Predicate<Integer> filter = num->num%numberToDivide==0;
        Consumer<Integer> printer = num-> System.out.print(num + " ");

        collection.removeIf(filter);
        Collections.reverse(collection);
        collection.stream().
                forEach(printer);

    }
}
