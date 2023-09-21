import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double,Integer> numberCounter = new LinkedHashMap<>();
        for (double number : numbers) {
            numberCounter.putIfAbsent(number,0);
            numberCounter.put(number,numberCounter.get(number)+1);
        }
        numberCounter.entrySet().forEach(number-> {
            System.out.printf("%.1f -> %d%n",number.getKey(),number.getValue());
        });
    }
}
