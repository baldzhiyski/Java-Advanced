package Exercise.StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        StackIterator stackIterator = new StackIterator();

        while (!line.equals("END")){
            if(line.contains("Push")){
                Arrays.stream(line.split("[\\s,]+"))
                        .skip(1)
                        .map(Integer::parseInt)
                        .forEach(stackIterator::push);
            }else if(line.equals("Pop")){
                try {
                   stackIterator.pop();
                }catch (IllegalStateException exception){
                    System.out.println(exception.getMessage());
                }
            }
            line=scan.nextLine();
        }
        stackIterator.forEach(System.out::println);
        stackIterator.forEach(System.out::println);
    }
}
