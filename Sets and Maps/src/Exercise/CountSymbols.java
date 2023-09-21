package Exercise;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Character,Integer> counter = new HashMap<>();
        for (char symbol : input.toCharArray()) {
            counter.putIfAbsent(symbol,0);
            counter.put(symbol,counter.get(symbol)+1);
        }
        counter.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry-> System.out.printf("%s: %d time/s\n",entry.getKey(),entry.getValue()));
    }
}
