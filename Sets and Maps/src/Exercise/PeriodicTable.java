package Exercise;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<String> chemicalCompounds = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            Collections.addAll(chemicalCompounds, data);
        }
        for (String chemicalCompound : chemicalCompounds) {
            System.out.print(chemicalCompound+ " ");
        }
    }
}
