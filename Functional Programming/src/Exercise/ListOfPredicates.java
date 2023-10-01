package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int end = Integer.parseInt(scan.nextLine());

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Predicate<Integer> predicate = number->{
            for (Integer integer : numbers) {
                if(number%integer!=0){
                    return false;
                }
            }
            return true;
        };
        for (int num = 1; num <=end; num++) {
            if(predicate.test(num)){
                System.out.print(num+ " ");
            }
        }

    }
}
