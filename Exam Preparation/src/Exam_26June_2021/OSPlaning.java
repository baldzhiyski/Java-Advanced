package Exam_26June_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(threads::offer);
        int valueToKill = Integer.parseInt(scan.nextLine());
        while (!threads.isEmpty() && !tasks.isEmpty()) {
            if(tasks.peek()==valueToKill){
                System.out.printf("Thread with value %d killed task %d\n",
                        threads.peek(),tasks.pop());
                break;
            }
            if (threads.peek() >= tasks.peek()) {
                threads.poll();
                tasks.pop();
            } else {
                threads.poll();
            }
        }
        threads.forEach(t-> System.out.print(t + " "));
    }
}
