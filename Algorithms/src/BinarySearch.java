import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = Integer.parseInt(scan.nextLine());

        // finds the position of a target value within a sorted array
        // fantastic with large data sets

        int result = binarySearch(numbers, n);

        System.out.println(result);
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // we go left side
            if (arr[mid] > target) {
                right = mid - 1;
            } else if(arr[mid]<target) {
                // we go right side;
                left = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
