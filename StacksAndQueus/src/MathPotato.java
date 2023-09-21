import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] childrenNames = scan.nextLine().split("\\s+");
        int neededTosses = Integer.parseInt(scan.nextLine());

        PriorityQueue<String> queue = new PriorityQueue<>();
        Collections.addAll(queue, childrenNames);

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < neededTosses; i++) {
                String ballHolder = queue.poll();
                queue.offer(ballHolder);
            }
            if(isPrime(cycle)){
                System.out.println("Prime "+ queue.peek());

            }else{
                System.out.println("Removed "+ queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if(cycle<=1){
            return false;
        }
        for (int i = 2; i < cycle; i++) {
            if(cycle%i==0){
                return false;
            }
        }
        return true;
    }
}
