package Exercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Person> personList = new ArrayList<>();
        while (!input.equals("END")){
            String[] tokens = input.split("\\s+");
            Person person = new Person(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
            personList.add(person);
            input=scan.nextLine();
        }
        int index = Integer.parseInt(scan.nextLine());
        int countMatches = 0;
        Person personToCompare = personList.get(index-1);
        personList.remove(index-1);
        for (Person person : personList) {
            int result = personToCompare.compareTo(person);
            if(result==0){
                countMatches++;
            }
        }
        if(countMatches==0){
            System.out.println("No matches");
        }else{
            System.out.printf("%d %d %d",countMatches+1,personList.size()-countMatches,personList.size()+1);
        }
    }
}
