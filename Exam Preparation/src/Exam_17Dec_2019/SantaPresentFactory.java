package Exam_17Dec_2019;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> materials = new ArrayDeque<>();
        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materials::push);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(magicLevel::offer);

        Map<String,Integer> presents = new LinkedHashMap<>();
        addingPresents(presents);

        Map<String,Integer> craftedPresent = new HashMap<>();
        boolean isDone = false;
        while (!materials.isEmpty() && !magicLevel.isEmpty()){
            int currentMaterial = materials.peek();
            int currentMagicLevel = magicLevel.peek();
            int result = currentMagicLevel*currentMaterial;

            if(currentMaterial==0 && currentMagicLevel==0){
                materials.pop();
                magicLevel.poll();
                continue;
            }
            if(currentMaterial==0){
                materials.pop();
                continue;
            }
            if(currentMagicLevel==0){
                magicLevel.poll();
                continue;
            }
            if(result<0){
                materials.push(materials.pop()+magicLevel.poll());
            }else if(result > 0 && !ableToCraft(result)){
                magicLevel.poll();
                materials.push(materials.pop()+15);
            }else if(result>0 && ableToCraft(result)){
                craft(result,presents,craftedPresent);
                materials.pop();
                magicLevel.poll();
            }
            if(checkForPairs(craftedPresent)){
                isDone=true;
            }
        }
        printMethod(isDone,materials,magicLevel,craftedPresent);
    }

    private static boolean ableToCraft(int result) {
        return result==150 || result==250 || result== 300 || result==400;
    }

    private static void printMethod(boolean isDone, ArrayDeque<Integer> materials, ArrayDeque<Integer> magicLevel, Map<String, Integer> craftedPresent) {
        if(isDone){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else{
            System.out.println("No presents this Christmas!");
        }
        Function<ArrayDeque<Integer>,String> convertFunc = deque -> deque.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));
        if(!materials.isEmpty()){
            System.out.print("Materials left: ");
            System.out.print(convertFunc.apply(materials));
            System.out.println();
        }
        if(!magicLevel.isEmpty()){
            System.out.print("Magic left: ");
            System.out.print(convertFunc.apply(magicLevel));
            System.out.println();
        }
        craftedPresent.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByKey())
                .forEach(toy-> System.out.printf("%s: %d\n",toy.getKey(),toy.getValue()));
    }

    private static boolean checkForPairs(Map<String, Integer> craftedPresent) {
       return (craftedPresent.containsKey("Doll") && craftedPresent.containsKey("Wooden train"))
               || (craftedPresent.containsKey("Teddy bear") && craftedPresent.containsKey("Bicycle"));
    }

    private static void craft(int result, Map<String, Integer> presents, Map<String, Integer> craftedPresent) {
        for (Map.Entry<String, Integer> present : presents.entrySet()) {
            if(result==present.getValue()){
                craftedPresent.putIfAbsent(present.getKey(),0);
                craftedPresent.put(present.getKey(),craftedPresent.get(present.getKey()) + 1);
            }
        }
    }

    private static void addingPresents(Map<String, Integer> presents) {
        presents.put("Doll",150);
        presents.put("Wooden train",250);
        presents.put("Teddy bear",300);
        presents.put("Bicycle",400);
    }
}
