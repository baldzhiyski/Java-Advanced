package Exercise.Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            Integer[] numbers = Arrays.stream(scan.nextLine().split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            Lake lake = new Lake(numbers);

            List<String> result = new ArrayList<>();

            lake.forEach(frog->result.add(String.valueOf(frog)));

            System.out.println(String.join(", ",result));
    }
}
