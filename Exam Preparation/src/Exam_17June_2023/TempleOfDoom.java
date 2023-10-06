package Exam_17June_2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> tools = new ArrayDeque<>();
        ArrayDeque<Integer> substances = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(tools::offer);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(substances::push);

        List<Integer> challenges = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!tools.isEmpty() && !substances.isEmpty() && !challenges.isEmpty()) {
            int tool = tools.poll();
            int substance = substances.pop();
            int result = tool * substance;
            if (checkResult(result, challenges)) {
                challenges.remove(Integer.valueOf(result));
            } else {
                tools.offer(tool + 1);
                int newSubstance = substance - 1;
                if (newSubstance > 0) {
                    substances.push(newSubstance);
                }
            }
        }
        if(!challenges.isEmpty()){
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }else{
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }
        printRemainingEl(tools,substances,challenges);
    }

    private static void printRemainingEl(ArrayDeque<Integer> tools, ArrayDeque<Integer> substances, List<Integer> challenges) {
        Function<ArrayDeque<Integer>,String> result = stack->stack.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));
        Function<List<Integer>,String> resultForList = list->list.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));
        if(!tools.isEmpty()){
            System.out.print("Tools: ");
            System.out.print(result.apply(tools) + System.lineSeparator());
        }
        if(!substances.isEmpty()){
            System.out.print("Substances: ");
            System.out.print(result.apply(substances) + System.lineSeparator());
        }
        if(!challenges.isEmpty()){
            System.out.print("Challenges: ");
            System.out.println(resultForList.apply(challenges) + System.lineSeparator());
        }
    }
    private static boolean checkResult(int result, List<Integer> challenges) {
        for (Integer challenge : challenges) {
            if(result==challenge){
                return true;
            }
        }
        return false;
    }
}