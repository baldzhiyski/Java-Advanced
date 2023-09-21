import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> sorted = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        for (int i = 0; i < sorted.size(); i++) {
            if(i==3){
                break;
            }
            System.out.print(sorted.get(i)+ " ");
        }
    }
}
