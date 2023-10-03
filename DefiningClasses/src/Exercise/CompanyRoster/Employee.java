package Exercise.CompanyRoster;

public class Employee {
    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        setName(name);
        setAge(age);
        setDepartment(department);
        setEmail(email);
        setSalary(salary);
        setPosition(position);
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public Employee(String name, double salary, String position, String department, int age) {
        this(name,salary,position,department,"n/a",age);
    }
    public Employee(String name,double salary,String position,String department){
        this(name,salary,position,department,"n/a",-1);
    }
    public Employee(String name, double salary, String position, String department, String email) {
        this(name,salary,position,department,email,-1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }
}
