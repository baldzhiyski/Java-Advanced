package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    public void add(Pet pet){
        if(data.size()<capacity){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        for (Pet pet : data) {
            if(pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name,String owner){
        for (Pet pet : data) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append("The grooming salon has the following clients:").append(System.lineSeparator());
        data.forEach(pet->result.append(pet.output()).append(System.lineSeparator()));
        return result.toString();
    }
}
