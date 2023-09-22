package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String commandLine = scan.nextLine();
        Map<String,Map<String,Integer>> venuesAndSingerHolder = new LinkedHashMap<>();
        String regex ="(?<name>[A-Za-z\\s]*)\\s@(?<location>[A-Za-z\\s]*)\\s(?<ticketPrice>[0-9]+)\\s(?<people>[0-9]+)";
        Pattern pattern =Pattern.compile(regex);
        while (!commandLine.equals("End")){
            Matcher matcher = pattern.matcher(commandLine);
            if(matcher.find()) {
                String venue = matcher.group("location");
                int ticketsPrice = Integer.parseInt(matcher.group("ticketPrice"));
                int amountOfTickets = Integer.parseInt(matcher.group("people"));
                String singerName = matcher.group("name");

                venuesAndSingerHolder.putIfAbsent(venue, new LinkedHashMap<>());
                venuesAndSingerHolder.get(venue).putIfAbsent(singerName, 0);
                venuesAndSingerHolder.get(venue).put(singerName, venuesAndSingerHolder.get(venue).get(singerName) + ticketsPrice * amountOfTickets);
            }
            commandLine= scan.nextLine();
        }
        venuesAndSingerHolder.entrySet().forEach(venue->{
            System.out.println(venue.getKey());
            venue.getValue().entrySet().stream().sorted((n1,n2)-> n2.getValue().compareTo(n1.getValue()))
                    .forEach(singer-> System.out.printf("#  %s -> %d\n",singer.getKey(),singer.getValue()));
        });
    }
}
