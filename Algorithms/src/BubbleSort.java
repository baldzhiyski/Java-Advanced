import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        /*
        pairs of adjacent elements are compared , and the elements swapped if they
        are not in order.
        Runtime complexity : O(n^2)
        bad for big data set
         */
        bubbleSort(numbers);
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = 0; j < numbers.length-i-1; j++) {
                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
    }
}
