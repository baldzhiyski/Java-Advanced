import java.util.*;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> grades = new TreeMap<>();
        for (int i = 0; i < numberOfStudents; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            double grade = Double.parseDouble(data[1]);
            grades.putIfAbsent(name,new ArrayList<>());
            grades.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> student : grades.entrySet()) {
            double average = 0;
            System.out.printf("%s -> ",student.getKey());
            for (Double grade : student.getValue()) {
                System.out.printf("%.2f ",grade);
                average+=grade;
            }
            average/=student.getValue().size();
            System.out.printf("(avg: %.2f)",average);
            System.out.println();
        }
    }
}
