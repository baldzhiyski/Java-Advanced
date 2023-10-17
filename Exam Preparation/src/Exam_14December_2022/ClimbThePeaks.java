package Exam_14December_2022;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> foodPortions = new ArrayDeque<>();
        ArrayDeque<Integer> staminaLevels = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(foodPortions::push);

        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(staminaLevels::offer);
        int num = 7;
        Map<String,Integer> peeks = new LinkedHashMap<>();
        addingToTheMap(peeks);
        List<String> conqueredPeaks = new ArrayList<>();
        while (num-->0){
            int foodPortion = foodPortions.pop();
            int stamina = staminaLevels.poll();
            int result = foodPortion+stamina;
            for (Map.Entry<String, Integer> peek : peeks.entrySet()) {
                if(result>=peek.getValue()) {
                    conqueredPeaks.add(peek.getKey());
                    peeks.remove(peek.getKey());
                }
                break;
            }
            if(peeks.isEmpty()){
                System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
                break;
            }
        }
        if(!peeks.isEmpty()){
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if(conqueredPeaks.size()>0){
            printPeeks(conqueredPeaks);
        }

    }

    private static void addingToTheMap(Map<String, Integer> peeks) {
        peeks.put("Vihren", 80);
        peeks.put("Kutelo", 90);
        peeks.put("Banski Suhodol", 100);
        peeks.put("Polezhan", 60);
        peeks.put("Kamenitza", 70);
    }

    private static void printPeeks(List<String> conqueredPeaks) {
        System.out.println("Conquered peaks:");
        conqueredPeaks.forEach(System.out::println);
    }
}
