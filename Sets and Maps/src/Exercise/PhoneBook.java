package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,String> nameAndPhoneHolder = new LinkedHashMap<>();
        while(!input.equals("search")){
            String[] data = input.split("-");
            String name = data[0];
            String phone = data[1];
            nameAndPhoneHolder.put(name,phone);
            input=scanner.nextLine();
        }
        input=scanner.nextLine();
        while(!input.equals("stop")){
            if(!nameAndPhoneHolder.containsKey(input)){
                System.out.printf("Contact %s does not exist.\n",input);
            }else{
                System.out.printf("%s -> %s\n",input,nameAndPhoneHolder.get(input));
            }
            input=scanner.nextLine();
        }
    }
}
