package Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        setName(name);
        this.employees = new ArrayList<>();
    }
    public void setName(String name) {
        this.name = name;
    }
    public double calculateAverageSalary(){
        return  this.employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    public void addEmployee(Employee employee) {
        getEmployees().add(employee);
    }

}
