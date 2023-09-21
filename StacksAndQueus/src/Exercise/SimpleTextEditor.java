package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfOperations = Integer.parseInt(scan.nextLine());
        ArrayDeque<String > commands = new ArrayDeque<>();
        ArrayDeque<String> removedElements = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < numberOfOperations; i++) {
            String rawCommand = scan.nextLine();
            String[] commandsArr = rawCommand.split("\\s+");
            switch (commandsArr[0]){
                case "1":
                    commands.push(rawCommand);
                    add(text,commandsArr[1]);
                    break;
                case "2":
                    commands.push(rawCommand);
                    int num = Integer.parseInt(commandsArr[1]);
                    saveDeletedElements(text,num,removedElements);
                    delete(text,num);
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(commandsArr[1 ])-1));
                    break;
                case "4":
                    String lastCommand = commands.pop();
                    String[] lastCommandArr = lastCommand.split("\\s+");
                    String type = lastCommandArr[0];
                    if(type.equals("1")){
                        text= new StringBuilder(text.toString().replace(lastCommandArr[1],""));
                    }else{
                        add(text,removedElements.pop());
                    }
                    break;
            }
        }
    }

    private static void saveDeletedElements(StringBuilder text, int num, ArrayDeque<String> removedElements) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            String deleted = String.valueOf(text.charAt(text.length()-1-i));
            builder.append(deleted);
        }
        removedElements.push(builder.reverse().toString());
    }

    private static void delete(StringBuilder text, int num) {
        int textLength = text.length();
        for (int i = 1; i <= num; i++) {
            text.deleteCharAt(textLength-i);
        }

    }

    private static void add(StringBuilder text, String s) {
        text.append(s);
    }
}
