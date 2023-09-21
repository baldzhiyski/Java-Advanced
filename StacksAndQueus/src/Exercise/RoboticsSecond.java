package Exercise;

import java.util.*;

public class RoboticsSecond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] robotsData = scan.nextLine().split(";");
        LinkedHashMap<String,Integer> robotsNameAndTime = addingTheRobotsDetails(robotsData);
        int[] robotsWorkingTime = new int[robotsData.length];//  how much times he works on current product

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
            for (int i = 0; i < robotsWorkingTime.length; i++) {
                if(robotsWorkingTime[i] == 0) {
                    // we check which robot is free ,  then we set his time with the help of the map
                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robotsNameAndTime.entrySet()){
                        if (count == i) { // we need to access the current name of the robot
                            // To do that : the count and index should be equal
                            robotsWorkingTime[i] = robot.getValue();

                            String time = getTimeAsInput(totalTimeSec);
                            System.out.printf("%s - %s %s%n", robot.getKey(), currentProduct, time);
                            isTaken =  true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            if(!isTaken){
                lineOfProducts.offer(currentProduct);
            }
        }

    }
    private static void decreaseWorkingTime(int[] robotsWorkingTime) {
        for (int i = 0; i < robotsWorkingTime.length; i++) {
            if(robotsWorkingTime[i]>0) {
                robotsWorkingTime[i]--;
            }
        }
    }

    private static String getTimeAsInput (int totalTimeSec){
        int hours = (totalTimeSec/3600)%24;
        int minutes = totalTimeSec%3600 / 60;
        int seconds = totalTimeSec % 60;
        return  "[" + String.format("%02d:%02d:%02d",hours,minutes,seconds) + "]";
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
