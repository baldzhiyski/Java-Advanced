package Exercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numEngines = Integer.parseInt(scan.nextLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new LinkedList<>();
        while (numEngines-->0){
            String[] inputData = scan.nextLine().split("\\s+");
            String model = inputData[0];
            int power = Integer.parseInt(inputData[1]);
            Engine engine;
            if(inputData.length==4){
                int displacement = Integer.parseInt(inputData[2]);
                String efficiency = inputData[3];
                engine=new Engine(model,power,displacement,efficiency);

            }else if(inputData.length==3){
                if(Character.isDigit(inputData[2].charAt(0))){
                    engine=new Engine(model,power,Integer.parseInt(inputData[2]));
                }else{
                    engine=new Engine(model,power,inputData[2]);
                }
            }else{
                engine=new Engine(model,power);
            }
            engines.put(model,engine);
        }
        int numCars = Integer.parseInt(scan.nextLine());
        while (numCars-->0){
            String[] inputData = scan.nextLine().split("\\s+");
            String model = inputData[0];
            String engineModel = inputData[1];
            Engine engine = engines.get(engineModel);
            Car car;
            if(inputData.length==4){
                int weight = Integer.parseInt(inputData[2]);
                String color = inputData[3];
                car=new Car(model,engine,weight,color);

            }else if(inputData.length==3){
                if(Character.isDigit(inputData[2].charAt(0))){
                    car=new Car(model,engine,Integer.parseInt(inputData[2]));
                }else{
                    car=new Car(model,engine,inputData[2]);
                }
            }else{
                car=new Car(model,engine);
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
