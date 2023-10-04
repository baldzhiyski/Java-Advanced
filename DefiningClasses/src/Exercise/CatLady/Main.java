package Exercise.CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        Map<String,Cat> catHolder = new HashMap<>();
        while (!command.equals("End")){
            String[] data = command.split("\\s+");
            String breed = data[0];
            String name = data[1];
            double num = Double.parseDouble(data[2]);

            Cat currentCat = new Cat();
            if(breed.equals("Siamese")){
                currentCat=new Siamese(name,num);
            }else if(breed.equals("Cymric")){
                currentCat=new Cymric(name,num);
            }else if (breed.equals("StreetExtraordinaire")){
                currentCat=new StreetExtraordinaire(name,num);
            }
            catHolder.put(name,currentCat);
            command=scan.nextLine();
        }
        String nameOfTheCat = scan.nextLine();

        catHolder.values().stream()
                .filter(item -> item.getName().equals(nameOfTheCat))
                .forEach(System.out::print);
    }
}
