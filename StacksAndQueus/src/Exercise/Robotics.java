package Exercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] robotsData = scan.nextLine().split(";");
        LinkedHashMap<String,Integer> robotsNameAndTime = addingTheRobotsDetails(robotsData);
        LinkedHashMap<String,Integer> robotsWorkingTime = getRobotsWorkingTimeMap(robotsData); // name and how much times he works on current product

        String[] startingTimeArr = scan.nextLine().split(":");
        int totalTimeSec = calculatingTotalTimeSeconds(startingTimeArr);

        ArrayDeque<String> lineOfProducts = new ArrayDeque<>();
        String product = scan.nextLine();

        while (!product.equals("End")){
            lineOfProducts.offer(product);
            product=scan.nextLine();
        }
        while (!lineOfProducts.isEmpty()){
            String currentProduct = lineOfProducts.poll();
            totalTimeSec++;

            decreaseWorkingTime(robotsWorkingTime);

            boolean isTaken = false;
            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if(robot.getValue()==0){ // free to take the product
                    String takenTime = getTimeAsInput(totalTimeSec);
                    System.out.println(robot.getKey() + " - " + currentProduct + " " + takenTime);
                    robotsWorkingTime.put(robot.getKey(),robotsNameAndTime.get(robot.getKey()));
                    isTaken=true;
                    break;
                }
            }
            if(!isTaken){
                lineOfProducts.offer(currentProduct);
            }
        }

    }

    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        robotsWorkingTime.entrySet().stream().filter(robot->robot.getValue()>0).forEach(robot-> {
            int leftTime = robot.getValue() - 1;
            robotsWorkingTime.put(robot.getKey(),leftTime);
        });
    }

    private static String getTimeAsInput (int totalTimeSec){
        int hours = (totalTimeSec/3600)%24;
        int minutes = totalTimeSec%3600 / 60;
        int seconds = totalTimeSec % 60;
        return  "[" + String.format("%02d:%02d:%02d",hours,minutes,seconds) + "]";
    }
    private static LinkedHashMap<String, Integer> getRobotsWorkingTimeMap(String[] robotsData) {
        LinkedHashMap<String,Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < robotsData.length; i++) {
            String name = robotsData[i].split("-")[0];
            robots.putIfAbsent(name,0);
        }
        return robots;

    }

    private static int calculatingTotalTimeSeconds(String[] startingTimeArr) {
        int hours = Integer.parseInt(startingTimeArr[0]);
        int minutes = Integer.parseInt(startingTimeArr[1]);
        int seconds = Integer.parseInt(startingTimeArr[2]);

        return hours*60*60 + minutes*60 + seconds;

    }
    private static LinkedHashMap<String,Integer> addingTheRobotsDetails(String[] robotsData) {
        LinkedHashMap<String,Integer> robotsNameAndTime = new LinkedHashMap<>();
        for (int i = 0; i < robotsData.length; i++) {
            String name = robotsData[i].split("-")[0];
            int processTime = Integer.parseInt(robotsData[i].split("-")[1]);
            robotsNameAndTime.putIfAbsent(name,processTime);
        }
        return robotsNameAndTime;
    }
}
