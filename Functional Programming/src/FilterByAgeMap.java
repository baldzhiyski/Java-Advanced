import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAgeMap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] data = scan.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            people.put(name, age);
        }
        String condition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Map.Entry<String, Integer>> filter = createFilter(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        people.entrySet().stream()
                .filter(filter)
                .forEach(printer);

    }
    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        if(format.equals("name")){
            return p-> System.out.println(p.getKey());
        }else if (format.equals("age")){
            return p-> System.out.println(p.getValue());
        }else{
            return p-> System.out.println(p.getKey()+ " - " + p.getValue());
        }
    }

    private static Predicate<Map.Entry<String,Integer>> createFilter(String condition, int age) {
        if(condition.equals("younger")){
            return p->p.getValue()<=age;
        }
        return p->p.getValue()>=age;
    }
}

