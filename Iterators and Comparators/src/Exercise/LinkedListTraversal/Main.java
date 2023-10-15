package Exercise.LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        LinkedList list = new LinkedList();

        while (number-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            if ("Add".equals(input[0])) {
                list.add(Integer.parseInt(input[1]));
            } else {
                list.remove(Integer.parseInt(input[1]));
            }
        }
        System.out.println(list.getSize());
        for (Object num : list) {
            System.out.print(num + " ");
        }
    }
}
