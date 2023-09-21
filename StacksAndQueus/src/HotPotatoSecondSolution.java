import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotatoSecondSolution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] childrenNames = scan.nextLine().split("\\s+");
        int neededTosses = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue,childrenNames);

        while (queue.size()>1){
            for (int i = 1; i < neededTosses; i++) {
               String ballHolder  = queue.poll();
               queue.offer(ballHolder);
            }
            System.out.println("Removed "+ queue.poll());
        }
        System.out.println("Last is "+ queue.poll());
    }
}
