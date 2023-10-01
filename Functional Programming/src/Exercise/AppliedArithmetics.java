package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();
        Function<List<Integer>,List<Integer>> adding = list->list.stream()
                .map(num->num+1)
                .collect(Collectors.toList());

        Function<List<Integer>,List<Integer>> multiply = list->list.stream()
                .map(num->num*2)
                .collect(Collectors.toList());

        Function<List<Integer>,List<Integer>> subtract = list->list.stream()
                .map(num->num-1)
                .collect(Collectors.toList());
        Consumer<Integer> print = num-> System.out.print(num+ " ");

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers=adding.apply(numbers);
                    break;
                case "subtract":
                    numbers=subtract.apply(numbers);
                    break;
                case "multiply":
                    numbers=multiply.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(print);
                    System.out.println();
            }

            command=scan.nextLine();
        }
    }
}
