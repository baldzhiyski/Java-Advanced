import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        Map<String,Map<String, List<String>>> map = new LinkedHashMap<>();
        for (int i = 0; i < number; i++) {
            String[] data = scan.nextLine().split(" ");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            map.putIfAbsent(continent,new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country,new ArrayList<>());
            map.get(continent).get(country).add(city);
        }
        map.entrySet().forEach(continent->{
            System.out.println(continent.getKey()+":");
            continent.getValue().entrySet()
                    .forEach(country->
                            System.out.println(" "+ country.getKey() + " -> " + String.join(", ",country.getValue())));
        });
    }
}
