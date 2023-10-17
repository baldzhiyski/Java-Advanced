package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private List<Student> data;
    private int capacity;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public int getCapacity(){
        return capacity;
    }
    public int getCount(){
        return data.size();
    }
    public String insert(Student student){
        if(data.size()==capacity){
            return "The hall is full.";
        }else if(data.contains(student)){
           return "Student is already in the hall.";
        }else{
            data.add(student);
            return  String.format("Added student %s %s.",student.getFirstName(),student.getLastName());
        }
    }
    public String remove(Student student){
        if(data.contains(student)){
            data.remove(student);
            return String.format("Removed student %s %s.",student.getFirstName(),student.getLastName());
        }else{
            return "Student not found.";
        }
    }
    public Student getStudent(String firstName , String lastName){
        return data.stream().filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst().get();
    }
    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append("Hall size: ").append(data.size());
        result.append(System.lineSeparator());
        data.forEach(student -> result.append(student.toString()).append(System.lineSeparator()));
        return result.toString();
    }
}
