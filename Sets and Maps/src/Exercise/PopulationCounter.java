package Exercise;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String,Map<String,Long>> holder = new LinkedHashMap<>();
        Map<String,Long> countryWithTotalPop = new LinkedHashMap<>();
        while (!input.equals("report")){
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            Long population = Long.valueOf(data[2]);

            holder.putIfAbsent(country,new LinkedHashMap<>());
            holder.get(country).putIfAbsent(city,population);

            input=scan.nextLine();
        }
        calculatingMethod(holder,countryWithTotalPop);
        countryWithTotalPop.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(country->{
                    System.out.printf("%s (total population: %d)\n",country.getKey(),country.getValue());
                    holder.get(country.getKey()).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(town-> System.out.printf("=>%s: %d\n",town.getKey(),town.getValue()));
                });
    }

    private static void calculatingMethod(Map<String, Map<String, Long>> holder, Map<String, Long> countryWithTotalPop) {
        for (Map.Entry<String, Map<String, Long>> country : holder.entrySet()) {
            long sumCountry = 0;
            for (Long value : country.getValue().values()) {
                sumCountry+=value;
            }
            countryWithTotalPop.put(country.getKey(),sumCountry);
        }
    }
}
