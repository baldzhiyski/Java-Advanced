import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> guestsList = new TreeSet<>();
        String guestID = scan.nextLine();
        while (!guestID.equals("PARTY")){
            guestsList.add(guestID);
            guestID=scan.nextLine();
        }
        guestID=scan.nextLine();
        while(!guestID.equals("END")){
            guestsList.remove(guestID);
            guestID=scan.nextLine();
        }
        System.out.println(guestsList.size());
        guestsList.forEach(System.out::println);
    }
}
