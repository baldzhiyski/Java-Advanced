package Exercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> nameAndIp = new TreeMap<>();
        Map<String,Integer> pointsForEachUser = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String Ip = data[0];
            String username = data[1];
            int points = Integer.parseInt(data[2]);

            if(!nameAndIp.containsKey(username)){
                nameAndIp.put(username,new ArrayList<>());
                nameAndIp.get(username).add(Ip);
                pointsForEachUser.put(username,points);
            }else{
                if(!nameAndIp.get(username).contains(Ip)){
                    nameAndIp.get(username).add(Ip);
                    pointsForEachUser.put(username,pointsForEachUser.get(username)+points);
                }else{
                    pointsForEachUser.put(username,pointsForEachUser.get(username)+points);
                }
            }

        }
        for (Map.Entry<String, List<String>> user : nameAndIp.entrySet()) {
            System.out.printf("%s: %d [", user.getKey(), pointsForEachUser.get(user.getKey()));
            Collections.sort(user.getValue());
            for (int i = 0; i < user.getValue().size(); i++) {
                if (i != user.getValue().size() - 1) {
                    System.out.printf("%s, ", user.getValue().get(i));
                } else {
                    System.out.printf("%s]%n", user.getValue().get(i));
                }
            }
        }
    }
}