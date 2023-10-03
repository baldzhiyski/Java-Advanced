package Exercise.SpeedRacing;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = Integer.parseInt(scan.nextLine());
        Map<String,Car> map = new LinkedHashMap<>();
        while (times-->0){
            String[] data = scan.nextLine().split("\\s+");
            String model = data[0];
            long fuel = Long.parseLong(data[1]);
            double fuelCostPerKm = Double.parseDouble(data[2]);
            Car car = new Car(model,fuel,fuelCostPerKm);
           map.putIfAbsent(model,car);
        }
        String command = scan.nextLine();
        while (!command.equals("End")){
            String model1 = command.split("\\s+")[1];
            long km = Long.parseLong(command.split("\\s+")[2]);
            Car car = map.get(model1);
            if(car.checkKm(km)){
                car.addDistance(km);
                car.reduceFuelAmount(km);
            }else{
                System.out.println("Insufficient fuel for the drive");
            }
            command=scan.nextLine();
        }
        map.entrySet().stream().forEach(car->{
            System.out.printf("%s %.2f %d\n",car.getValue().model,car.getValue().fuel,car.getValue().distanceTraveled);
        });
    }
}
