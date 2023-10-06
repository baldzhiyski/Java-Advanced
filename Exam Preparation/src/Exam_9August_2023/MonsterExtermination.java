package Exam_9August_2023;

import java.util.*;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> armorValuesOfMonsters = new ArrayDeque<>();
        ArrayDeque<Integer> strengthValuesOfSoldier = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(armorValuesOfMonsters::offer);
        Arrays.stream(scan.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(strengthValuesOfSoldier::push);

        int killedMonstersCount=0;
        while (!armorValuesOfMonsters.isEmpty() && !strengthValuesOfSoldier.isEmpty()) {
            int strength = strengthValuesOfSoldier.peek();
            int armour = armorValuesOfMonsters.peek();
            if(strength>=armour){
                strength-=armour;
                killedMonstersCount++;
                if(strength==0){
                    strengthValuesOfSoldier.pop();
                    armorValuesOfMonsters.poll();
                }else{
                    armorValuesOfMonsters.poll();
                    if(strengthValuesOfSoldier.size()==1){
                        strengthValuesOfSoldier.pop();
                        strengthValuesOfSoldier.push(strength);
                    }else{
                        strengthValuesOfSoldier.pop();
                        int previousStrike = strengthValuesOfSoldier.pop();
                        strengthValuesOfSoldier.push(previousStrike+strength);
                    }
                }
            }else{
                armour-=strength;
                strengthValuesOfSoldier.pop();
                armorValuesOfMonsters.poll();
                armorValuesOfMonsters.offer(armour);
            }
        }
        if(armorValuesOfMonsters.isEmpty()){
            System.out.println("All monsters have been killed!");
        }
        if(strengthValuesOfSoldier.isEmpty()){
            System.out.println("The soldier has been defeated.");
        }
        System.out.println("Total monsters killed: "+ killedMonstersCount);

    }
}
