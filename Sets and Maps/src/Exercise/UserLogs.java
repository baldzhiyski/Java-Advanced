package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Map<String,Integer>> data = new TreeMap<>();
        String input = scan.nextLine();

        while (!input.equals("end")){
            String[] allData = input.split(" ");
            String Ip = allData[0].split("=")[1];
            String username = allData[2].split("=")[1];

            data.putIfAbsent(username,new LinkedHashMap<>());
            data.get(username).putIfAbsent(Ip,0);
            data.get(username).put(Ip,data.get(username).get(Ip)+1);

            input=scan.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> user : data.entrySet()) {
            StringBuilder result = new StringBuilder();
            System.out.println(user.getKey()+": ");
            for (Map.Entry<String, Integer> Ip : user.getValue().entrySet()) {
                result.append(Ip.getKey()+ " => " + Ip.getValue() + ", ");
            }
            result.deleteCharAt(result.length()-1);
            result.deleteCharAt(result.length()-1);
            result.append(".");
            System.out.println(result);
        }
    }
}
