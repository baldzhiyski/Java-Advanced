package CarConstructors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<CarConstructors.Car> carsFolder = new ArrayList<>();
        while (num-->0){
            String[] commandLine = scan.nextLine().split("\\s+");
            String brand = commandLine[0];
            if(commandLine.length==1){
                Car car = new Car(brand);
                carsFolder.add(car);
            }else {
                String model = commandLine[1];
                int horsePower = Integer.parseInt(commandLine[2]);
                Car car = new Car(brand,model,horsePower);
                carsFolder.add(car);
            }
        }
        carsFolder.forEach(car-> System.out.println(car.toString()));
    }
}
