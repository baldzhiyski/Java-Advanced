package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> guests = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(String::valueOf)
                .collect(Collectors.toList());
        String command = scan.nextLine();
        Predicate<String> predicate;
        while (!command.equals("Party!")){
            String[] commandArr = command.split("\\s+");
            String criteria = commandArr[2];
            if(command.contains("StartsWith")){
                predicate=name->name.startsWith(criteria);
            }else if(command.contains("EndsWith")){
                predicate = name->name.endsWith(criteria);
            }else{
                predicate=name->name.length()==Integer.parseInt(criteria);
            }
            if(commandArr[0].equals("Remove")){
                guests.removeIf(predicate);
            }else if(commandArr[0].equals("Double")){
                List<String> guestsToDouble = guests.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
                guests.addAll(guestsToDouble);
                guestsToDouble.clear();
            }
            command=scan.nextLine();
        }
        if(guests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            String result = guests.stream().sorted().collect(Collectors.joining(", "));
            System.out.println(result+ " are going to the party!");
        }
    }
}
