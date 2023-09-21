import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> studentSummary  = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            List<Double> gradesList = Arrays.stream(scan.nextLine().split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            studentSummary.putIfAbsent(name,new ArrayList<>());
            studentSummary.get(name).addAll(gradesList);
        }
        studentSummary.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(student->{
                    double average = 0;
                    for (Double grade : student.getValue()) {
                        average+=grade;
                    }
                    average/=student.getValue().size();
                    System.out.println(String.format("%s is graduated with %s", student.getKey(), average));
        });
    }

}
