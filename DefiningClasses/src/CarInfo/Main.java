package CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Car> carsFolder = new ArrayList<>();
        while (num-->0){
            String[] commandLine = scan.nextLine().split("\\s+");
            String brand = commandLine[0];
            String model = commandLine[1];
            int horsePower = Integer.parseInt(commandLine[2]);


            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);
            carsFolder.add(car);
        }
        carsFolder.forEach(car-> System.out.println(car.toString()));
    }
}
