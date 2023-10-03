package Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = Integer.parseInt(scan.nextLine());
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();
        while (times-->0) {
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            Employee employee;
            if (data.length == 5) {
                if (data[4].contains("@")) {
                    String email = data[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(data[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (data.length == 4) {
                employee = new Employee(name, salary, department, position);
            } else {
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }
            employees.add(employee);

            if (!departments.stream().anyMatch(dep1 -> dep1.getName().equals(department))) {
                Department department1 = new Department(department);
                departments.add(department1);
            }
            Department currentDepartment = departments.stream()
                    .filter(dep -> dep.getName().equals(department))
                    .findFirst()
                    .get();

            currentDepartment.addEmployee(employee);

        }

        Department highestDepartmentSalary = departments.stream().max((first,second)->
                Double.compare(first.calculateAverageSalary(), second.calculateAverageSalary())).get();

        System.out.printf("Highest Average Salary: %s%n", highestDepartmentSalary.getName());

        highestDepartmentSalary.getEmployees()
                .stream()
                .sorted((first, second) -> Double.compare(second.getSalary(), first.getSalary()))
                .forEach(employee -> System.out.printf("%s %.2f %s %d%n", employee.getName()
                        , employee.getSalary(), employee.getEmail(), employee.getAge()));
    }
}
