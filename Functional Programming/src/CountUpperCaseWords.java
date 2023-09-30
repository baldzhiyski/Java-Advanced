import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String[] words = input.split("\\s+");

        Predicate<String> isUpperCase = word->Character.isUpperCase(word.charAt(0));

        Function<String[],List<String>> getUpperCaseWords = arr->Arrays.stream(arr)
                .filter(isUpperCase)
                .collect(Collectors.toList());

        List<String> upper = getUpperCaseWords.apply(words);
        System.out.println(upper.size());

        Consumer<String> print = System.out::println;
        upper.forEach(print);
    }
}
