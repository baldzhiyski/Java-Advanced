package Exercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();
        String inputLine = scan.nextLine();

        while (!inputLine.equals("END")){
            String[] data = inputLine.split("\\s+");
            String command = data[0];
            switch (command){
                case "Add":
                    customList.add(data[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(data[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(data[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(data[1]),Integer.parseInt(data[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(data[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String string : customList) {
                        System.out.println(string);
                    }
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }
            inputLine=scan.nextLine();
        }
    }
}
