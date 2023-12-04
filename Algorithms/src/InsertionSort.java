import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        insertionSort(numbers);
        /*
        after comparing elements to the left
        shift elements to the right to make room to insert a value

        Quadratic time O(n^2)
        small data set = decent
        large data set = bad

        Fewer steps than Bubble sort
         */

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static void insertionSort(int[] numbers) {
        for (int index = 1; index <= numbers.length-1; index++) {
            int temp = numbers[index];
            int prevValueIndex = index-1;

            while (prevValueIndex>=0 && numbers[prevValueIndex]>temp){
                numbers[prevValueIndex+1]=numbers[prevValueIndex];
                prevValueIndex--;
            }
            numbers[prevValueIndex+1]=temp;
        }
    }
}
