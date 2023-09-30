import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> unsortedEvenNumbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n%2==0)
                .collect(Collectors.toList());

        Function<List<Integer>,String> format = list->list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(format.apply(unsortedEvenNumbers));

        List<Integer> sorted = unsortedEvenNumbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(format.apply(sorted));
    }
}
