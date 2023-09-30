import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        UnaryOperator<String> addVat =  s -> String.format("%.2f", Double.parseDouble(s) * 1.2); // function
        System.out.println("Prices with VAT:");

        Arrays.stream(scan.nextLine().split(", "))
                .map(addVat) // here we need a function that does something
                .forEach(System.out::println);
    }
}
