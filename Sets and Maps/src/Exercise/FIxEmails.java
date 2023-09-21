package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FIxEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        Map<String , String> holder = new LinkedHashMap<>();
        while(!command.equals("stop")){
            String name = command;
            String email = scan.nextLine();
            holder.putIfAbsent(name,email);
            command=scan.nextLine();
        }
        holder.entrySet().stream().filter(entry->!entry.getValue()
                .contains(".us") && !entry.getValue().contains(".com") && !entry.getValue().contains(".uk"))
                .forEach(name-> System.out.println(name.getKey() + " -> " + name.getValue()));

    }
}
