import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
        int sumCollected = usedCoins.entrySet().stream()
                .mapToInt(e -> e.getKey() * e.getValue())
                .sum();

        if (sumCollected != targetSum) {
            System.out.println("Error");
        } else {
            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
                System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
            }
        }

    }
    public static Map<Integer, Integer> chooseCoins ( int[] coins, int targetSum){
        Map<Integer,Integer> countedCoins = new LinkedHashMap<>();
        int index = coins.length-1;
        while (targetSum>0 && index>=0) {
            int coin = coins[index];
            int times = targetSum / coin;
            if(times!=0){
                countedCoins.put(coin,times);
            }
            targetSum = targetSum % coin;
            index--;
        }
        return countedCoins;
    }
}
