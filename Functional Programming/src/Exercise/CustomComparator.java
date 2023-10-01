package Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Comparator<Integer> comparator = (num1,num2)->{
            if(num1%2==0 && num2%2!=0){
                return -1;
            }else if(num1%2!=0 && num2%2==0){
                return 1;
            }
            return num1.compareTo(num2);
        };
        Arrays.stream(numbers).sorted(comparator)
                .forEach(e-> System.out.print(e + " "));
    }
}
