package Exercise;

import java.util.*;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] lengths = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < lengths[0]; i++) {
            int num = Integer.parseInt(scan.nextLine());
            firstSet.add(num);
        }
        for (int i = 0; i < lengths[1]; i++) {
            int num = Integer.parseInt(scan.nextLine());
            secondSet.add(num);
        }
        firstSet.retainAll(secondSet);
        for (Integer integer : firstSet) {
            System.out.print(integer+ " ");
        }
    }
}
