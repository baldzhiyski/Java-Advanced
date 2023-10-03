package Exercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Car> carList = new ArrayList<>();
        int times = Integer.parseInt(scan.nextLine());
        while (times-->0) {
            String[] data = scan.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tire1Pressure = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            double tire3Pressure = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);

            Car current = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1Pressure, tire1Age,
                    tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            carList.add(current);
        }
            String command = scan.nextLine();
            if(command.equals("fragile")){
                for (Car car : carList) {
                    if (car.getTires().ifTirePressureIsUnder() && car.getCargo().getType().equals("fragile")) {
                        System.out.printf("%s%n",car.getModel());
                    }
                }
            }else if(command.equals("flamable")){
                for (Car car : carList) {
                    if(car.getCargo().getType().equals("flamable") && car.getEngine().getPower()>250){
                        System.out.printf("%s%n",car.getModel());
                    }
                }
            }
    }

}
