package Exam_12April_2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> queueWithTime = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queueWithTime::offer);
        ArrayDeque<Integer> stackNumberTasks = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stackNumberTasks::push);

        int darthVaderDucky = 0;
        int thorDucky = 0;
        int bigBlueRubberDucky = 0;
        int smallYellowRubberDucky = 0;

        while (true){
            if(stackNumberTasks.isEmpty() || queueWithTime.isEmpty()){
                break;
            }
            int time = queueWithTime.pop();
            int task = stackNumberTasks.pop();
            int result = task*time;
            if(result<=60){
                darthVaderDucky++;
            }else if(result<=120){
                thorDucky++;
            }else if(result<=180){
                bigBlueRubberDucky++;
            }else if(result<=240){
                smallYellowRubberDucky++;
            }else {
                stackNumberTasks.push(task-2);
                queueWithTime.offer(time);
            }
        }
        print(darthVaderDucky,thorDucky,bigBlueRubberDucky,smallYellowRubberDucky);
    }

    private static void print(int darthVaderDucky, int thorDucky, int bigBlueRubberDucky, int smallYellowRubberDucky) {
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d%nThor Ducky: %d%nBig Blue Rubber Ducky: %d%nSmall Yellow Rubber Ducky: %d"
        ,darthVaderDucky,thorDucky,bigBlueRubberDucky,smallYellowRubberDucky);
    }
}
