package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class  PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPlants = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> plantStack = movingAllPlantsIntoStackCollection(scan.nextLine(),numberOfPlants);
        ArrayDeque<Integer> container = new ArrayDeque<>();

        int days = 0;

        while (true){

            int sizeBeforeEndOfDay = plantStack.size();

            while(!plantStack.isEmpty()){
                int currentPlant = plantStack.pop();
                if(plantStack.size()>=1){
                    int plantLeft = plantStack.peek();
                    if(currentPlant<=plantLeft){
                        container.push(currentPlant);
                    }
                }else{
                    container.push(currentPlant);
                }

            }
            moveBackRemainingPlants(plantStack,container);
            int sizeAfterTheDay = plantStack.size();
            if(sizeAfterTheDay==sizeBeforeEndOfDay){
                break;
            }
            days++;
        }
        System.out.println(days);
    }

    private static void moveBackRemainingPlants(ArrayDeque<Integer> plantStack, ArrayDeque<Integer> container) {
        while (!container.isEmpty()){
            plantStack.push(container.pop());
        }
    }

    private static ArrayDeque<Integer> movingAllPlantsIntoStackCollection(String nextLine, int numberOfPlants) {
        ArrayDeque<Integer> temporary = new ArrayDeque<>();
        int[] pesticide = Arrays.stream(nextLine.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < pesticide.length; i++) {
            temporary.push(pesticide[i]);
        }
        return temporary;
    }
}
