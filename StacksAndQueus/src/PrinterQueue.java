import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> fileNames = new ArrayDeque<>();
        String input = scan.nextLine();
        while(!input.equals("print")){
            if(input.equals("cancel")){
                if(!fileNames.isEmpty()){
                    String canceledFile = fileNames.poll();
                    System.out.println("Canceled "+ canceledFile);
                }else{
                    System.out.println( "Printer is on standby");
                }
            }else{
                fileNames.offer(input);
            }
            input=scan.nextLine();
        }
        while (!fileNames.isEmpty()){
            System.out.println(fileNames.pollFirst());
        }
    }
}
