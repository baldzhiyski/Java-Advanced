import java.util.*;
import java.util.stream.Collectors;

public class War {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<Integer> firstDeck = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondDeck = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 50;
        while (round-->=0){
            int firstPlayerCard = firstDeck.iterator().next();
            firstDeck.remove(firstPlayerCard);

            int secondPlayerCard = secondDeck.iterator().next();
            secondDeck.remove(secondPlayerCard);

            if(firstPlayerCard>secondPlayerCard){
                firstDeck.add(firstPlayerCard);
                firstDeck.add(secondPlayerCard);
            }else if(secondPlayerCard>firstPlayerCard){
                secondDeck.add(secondPlayerCard);
                secondDeck.add(firstPlayerCard);
            }
            if(firstDeck.isEmpty() || secondDeck.isEmpty()){
                break;
            }
        }
        if(firstDeck.size()<secondDeck.size()){
            System.out.println("Second player win!");
        }else if (secondDeck.size()<firstDeck.size()){
            System.out.println("First player win!");
        }else{
            System.out.println("Draw!");
        }
    }
}
