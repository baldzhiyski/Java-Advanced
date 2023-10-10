package Exercise.Threeuple;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Threeuple<String, String,String>> threeuples = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (i == 0) {
                String name = input[0] + " " + input[1];
                String address = input[2];
                String town = input[3];
                threeuples.add(new Threeuple<>(name,address,town));
            } else if (i == 1) {
                String name = input[0];
                String liters = input[1];
                String condition = input[2];
                if(condition.equals("drunk")){
                    condition="true";
                }else{
                    condition="false";
                }
                threeuples.add(new Threeuple<>(name, liters,condition));
            } else {
                String name = input[0];
                double accountBalance = Double.parseDouble(input[1]);
                String bankName = input[2];
                threeuples.add(new Threeuple<>(name,String.valueOf(accountBalance),bankName));
            }
        }
        threeuples.forEach(System.out::println);
    }
}
