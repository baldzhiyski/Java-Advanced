package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterMode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> guests = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(String::valueOf)
                .collect(Collectors.toList());
        List<String> filteredGuests = new ArrayList<>();
        String command = scan.nextLine();
        Predicate<String> predicate;
        while (!command.equals("Print")){
            String[] arr = command.split(";");
            String filterParameter =arr[2];
            if(command.contains("Starts with")){
                predicate=name->name.startsWith(filterParameter);
            }else if(command.contains("Ends with")){
                predicate=name->name.endsWith(filterParameter);
            }else if(command.contains("Length")){
                predicate=name->name.length()==Integer.parseInt(filterParameter);
            }else {
                predicate=name->name.contains(filterParameter);
            }
            if(arr[0].equals("Add filter")){
                List<String> removed = guests.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
                guests.removeIf(predicate);
                filteredGuests.addAll(removed);
            }else if(arr[0].equals("Remove filter")){
                guests.addAll(filteredGuests.stream().filter(predicate).collect(Collectors.toList()));
                filteredGuests.removeIf(predicate);
            }
            command=scan.nextLine();
        }
        guests.forEach(guest-> System.out.print(guest+" "));
    }
}
