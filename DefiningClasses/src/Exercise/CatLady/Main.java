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

            Cat currentCat=null;
            if(breed.equals("Siamese")){
                currentCat=new Siamese(name,breed,num);
            }else if(breed.equals("Cymric")){
                currentCat=new Cymric(name,breed,num);
            }else if (breed.equals("StreetExtraordinaire")){
                currentCat=new StreetExtraordinaire(name,breed,num);
            }
            catHolder.put(name,currentCat);
            command=scan.nextLine();
        }
        String nameOfTheCat = scan.nextLine();

        System.out.println(catHolder.get(nameOfTheCat));
    }
}
