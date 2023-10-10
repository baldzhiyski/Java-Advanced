package Exercise.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Box<Double> list = new Box<>();
        for (int i = 0; i < n; i++) {
            list.add(Double.parseDouble(scan.nextLine()));
        }
        double elementToCompare = Double.parseDouble(scan.nextLine());
        System.out.println(list.countOfGreaterItems(elementToCompare));

    }
}
