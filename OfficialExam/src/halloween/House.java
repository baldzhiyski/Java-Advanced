package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addKid(Kid kid){
        if(this.data.size()<capacity){
            this.data.add(kid);
        }
    }
    public boolean removeKid(String name){
        for (Kid kid : data) {
            if(kid.getName().equals(name)){
                data.remove(kid);
                return true;
            }
        }
        return false;
    }
    public Kid getKid(String street){
        for (Kid kid : data) {
            if(kid.getStreet().equals(street)){
                return kid;
            }
        }
        return null;
    }
    public int getAllKids(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append("Children who visited a house for candy:").append(System.lineSeparator());
        data.forEach(kid->result.append(kid.toOutput()).append(System.lineSeparator()));
        return result.toString();
    }
}
