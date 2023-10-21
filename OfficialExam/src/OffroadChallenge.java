import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> fuels = new ArrayDeque<>();
        ArrayDeque<Integer> consumptionIndexes = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(fuels::push);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(consumptionIndexes::offer);

        List<Integer> quantities = Arrays.stream(scan.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int level = 0;
        int n = 4;
        int initialSize = quantities.size();
        while (n-->0){
            int fuel = fuels.pop();
            int consumption = consumptionIndexes.poll();
            int result = fuel-consumption;
            if(result>=quantities.get(level)){
                level++;
                System.out.println("John has reached: Altitude " + level);
            }else{
                System.out.println("John did not reach: Altitude " + (level+1));
                break;
            }
        }
        printMethod(quantities, level);
    }

    private static void printMethod(List<Integer> quantities, int level) {
        if(level < quantities.size() && level >0){
            System.out.println("John failed to reach the top.");
            System.out.print("Reached altitudes: ");
            for (int i = 1; i <= level; i++) {
                if(i== level){
                    System.out.print("Altitude "+ i );
                }else {
                    System.out.print("Altitude " + i + ", ");
                }
            }
        }else if(level ==0 ){
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        }else if(level == quantities.size()){
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
    }
}
