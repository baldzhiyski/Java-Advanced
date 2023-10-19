import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        System.out.println(findFactorial(num));
    }

    private static long findFactorial(int num) {
        if(num==1){
            return 1;
        }
        return num*findFactorial(num-1);
    }
}
