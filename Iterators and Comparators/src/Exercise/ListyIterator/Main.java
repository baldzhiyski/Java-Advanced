package Exercise.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        ListyIterator<String> listyIterator = new ListyIterator<>();
        while (!line.equals("END")) {
            if (line.contains("Create")) {
                String[] tokens = Arrays.stream(line.split("\\s+")).skip(1).toArray(String[]::new);
                listyIterator= new ListyIterator<>(tokens);
            }else if(line.equals("Move")){
                System.out.println(listyIterator.move());
            }else if(line.equals("HasNext")){
                System.out.println(listyIterator.hasNext());
            }else if(line.equals("Print")){
                listyIterator.print();
            }else if(line.equals("PrintAll")){
                for (String string : listyIterator) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }
            line=scan.nextLine();
        }

    }
}
