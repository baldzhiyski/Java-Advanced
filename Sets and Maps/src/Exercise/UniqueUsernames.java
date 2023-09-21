package Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Set<String> namesHolder = new LinkedHashSet<>();
        for (int i = 0; i < num; i++) {
            String name = scan.nextLine();
            namesHolder.add(name);
        }
        namesHolder.forEach(System.out::println);
    }
}
