import java.util.Arrays;
import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(sum(arr,0));
    }

    private static int sum(int[] nums, int index) {
        if(index==nums.length-1){
            return nums[index];
        }
        return  nums[index] + sum(nums,index+1);
    }
}
