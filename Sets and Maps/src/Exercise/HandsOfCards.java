package Exercise;

import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String,Integer> cardsValue = new LinkedHashMap<>();
        Map<String,Integer> characterValues = Map.of("S",4,
                "H",3,
                "D",2,
                "C",1);
        for (int i = 2; i <=10; i++) {
            cardsValue.put(String.valueOf(i),i);
        }
        cardsValue.put("J",11);
        cardsValue.put("Q",12);
        cardsValue.put("K",13);
        cardsValue.put("A",14);

        Map<String, Set<String>> playerHolder = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] data = input.split(": ");
            String name = data[0];
            String[]cards = data[1].split(", ");
            playerHolder.putIfAbsent(name,new LinkedHashSet<>());
            playerHolder.get(name).addAll(List.of(cards));
            input=scan.nextLine();
        }
        playerHolder.entrySet().forEach(entry->{
            int sum = calculateSum(entry.getValue(),cardsValue,characterValues);
            System.out.printf("%s: %d\n",entry.getKey(),sum);
        });
    }

    private static int calculateSum(Set<String> value, Map<String, Integer> cardsValue, Map<String, Integer> characterValues) {
        int sum = 0;
        for (String string : value) {
            String card =  string.substring(0,string.length()-1);
            String symbol = string.charAt(string.length()-1) + "";
            sum+=cardsValue.get(card)*characterValues.get(symbol);
        }
        return sum;

    }
}
