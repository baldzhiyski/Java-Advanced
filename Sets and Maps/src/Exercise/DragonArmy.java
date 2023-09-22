package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    private static final int defaultHealth = 250;
    private static final int  defaultArmour = 10;
    private static final int  defaultDamage = 45;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Map<String,int[]>> dragonHolder = new LinkedHashMap<>();
        int number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < number; i++) {
            String[] data = scan.nextLine().split(" ");
            String type = data[0];
            String nameOfDragon = data[1];
            int damage = data[2].equals("null") ? defaultDamage : Integer.parseInt(data[2]);
            int health = data[3].equals("null") ? defaultHealth : Integer.parseInt(data[3]);
            int armour = data[4].equals("null") ? defaultArmour : Integer.parseInt(data[4]);

            dragonHolder.putIfAbsent(type,new TreeMap<>());
            dragonHolder.get(type).putIfAbsent(nameOfDragon,new int[3]);
            dragonHolder.get(type).get(nameOfDragon)[0]=damage;
            dragonHolder.get(type).get(nameOfDragon)[1]=health;
            dragonHolder.get(type).get(nameOfDragon)[2]=armour;
        }
        dragonHolder.entrySet().forEach(type->{
            calculateAverage(type.getKey(),type.getValue());
            type.getValue().entrySet()
                    .forEach(dragon-> System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n"
                    ,dragon.getKey(),dragon.getValue()[0],dragon.getValue()[1],dragon.getValue()[2]));
        });
    }

    private static void calculateAverage(String key, Map<String, int[]> dragonHolder) {
        double sumHealth=0;
        double sumArmour=0;
        double sumDamage=0;
        double length = dragonHolder.size();
        for (Map.Entry<String, int[]> name : dragonHolder.entrySet()) {
            sumDamage+=name.getValue()[0];
            sumArmour+=name.getValue()[2];
            sumHealth+=name.getValue()[1];
        }
        double averageDamage = sumDamage/length;
        double averageHealth= sumHealth/length;
        double averageArmour = sumArmour/length;
        System.out.printf("%s::(%.2f/%.2f/%.2f)\n",key,averageDamage,averageHealth,averageArmour);
    }

}
