import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sorted = mergeSort(numbers);
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
    private static int[] mergeSort(int[] array){
        if(array.length==1){
            return array;
        }
        int halfIndex = array.length/2;
        int secondArrayLength = array.length-halfIndex;

        int[] firstPortion = new int[halfIndex];
        int[] secondPortion = new int[secondArrayLength];

        for (int i = 0; i < firstPortion.length; i++) {
            firstPortion[i]=array[i];
        }
        for (int i = halfIndex; i <halfIndex+secondArrayLength; i++) {
            secondPortion[i-halfIndex]=array[i];
        }
        // we have filled both arrays
        firstPortion=mergeSort(firstPortion);
        secondPortion=mergeSort(secondPortion);

        int mainIndex =0;

        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;

        while (firstPartitionIndex<halfIndex && secondPartitionIndex<secondArrayLength){
            if(firstPortion[firstPartitionIndex] < secondPortion[secondPartitionIndex]){
                array[mainIndex]= firstPortion[firstPartitionIndex];
                mainIndex++;
                firstPartitionIndex++;
            }else{
                array[mainIndex] = secondPortion[secondPartitionIndex];
                mainIndex++;
                secondPartitionIndex++;
            }
        }
        while (firstPartitionIndex<halfIndex){
            array[mainIndex] = firstPortion[firstPartitionIndex];

            mainIndex++;
            firstPartitionIndex++;
        }
        while(secondPartitionIndex<secondArrayLength){
            array[mainIndex]= secondPortion[secondPartitionIndex];

            mainIndex++;
            secondPartitionIndex++;
        }
        return array;
    }
}
