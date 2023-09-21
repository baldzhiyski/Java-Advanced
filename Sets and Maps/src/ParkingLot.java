import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Set<String> parking = new LinkedHashSet<>();
        while(!input.equals("END")){
            String[] data = input.split(", ");
            switch (data[0]){
                case "IN":
                    parking.add(data[1]);
                    break;
                case "OUT":
                    parking.remove(data[1]);
                    break;
            }
            input=scan.nextLine();
        }
        if(parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            parking.forEach(System.out::println);
        }
    }
}
