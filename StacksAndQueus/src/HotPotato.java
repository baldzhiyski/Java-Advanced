import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] childrenNames = scan.nextLine().split("\\s+");
        int neededTosses = Integer.parseInt(scan.nextLine());
        String ballHolder = "";
        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue,childrenNames);

        int numberOfTosses = 0;
        while (queue.size()>1){
            numberOfTosses++;
            ballHolder = queue.poll(); // the first one - we take him/her and then add him/her to the back of the queue
            if(numberOfTosses==neededTosses){
                System.out.println("Removed "+ ballHolder);
                numberOfTosses=0;
                continue;
            }
            queue.offer(ballHolder);
        }
        System.out.println("Last is "+ queue.poll());
    }
}
