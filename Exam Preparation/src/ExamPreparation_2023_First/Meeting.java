package ExamPreparation_2023_First;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(males::push);
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(females::offer);
        int matches = 0;

        while (!females.isEmpty() && !males.isEmpty()){
            int currentFemale = females.peek();
            int currentMale = males.peek();
            if(currentFemale<=0){
                females.poll();
                continue;
            }
            if(currentMale<=0){
                males.pop();
                continue;
            }
            if(currentMale%25==0){
                males.pop();
                males.pop();
                continue;
            }else if(currentFemale%25==0){
                females.poll();
                females.poll();
                continue;
            }
            females.poll();
            if(currentFemale==currentMale){
                males.pop();
                matches++;
            }else{
                males.push(males.pop()-2);
            }

        }
        print(females,males,matches);
    }

    private static void print(ArrayDeque<Integer> females, ArrayDeque<Integer> males, int matches) {
        System.out.println("Matches: "+ matches);
        Function<ArrayDeque<Integer>,String> format = deque->deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        if(!males.isEmpty()){
            System.out.println("Males left: " +format.apply(males));
        }else{
            System.out.println("Males left: none");
        }
        if(!females.isEmpty()){
            System.out.println("Females left: " + format.apply(females));
        }else{
            System.out.println("Females left: none");
        }
    }
}
