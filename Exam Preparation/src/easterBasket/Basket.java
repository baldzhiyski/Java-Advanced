package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addEgg(Egg egg){
        if(data.size()<capacity){
            data.add(egg);
        }
    }
    public boolean removeEgg(String color){
        for (Egg egg : data) {
            if(egg.getColor().equals(color)){
                data.remove(egg);
                return true;
            }
        }
        return false;
    }
    public Egg getStrongestEgg(){
       return data.stream().max(Comparator.comparing(Egg::getStrength)).get();
    }
    public Egg getEgg(String color){
        return this.data.stream().filter(egg->egg.getColor().equals(color)).findFirst().get();
    }
    public int getCount(){
        return this.data.size();
    }
    public String report(){
        StringBuilder result = new StringBuilder();
        result.append(material).append(" basket contains:");
        result.append(System.lineSeparator());
        data.forEach(egg -> result.append(egg.toString()).append(System.lineSeparator()));
        return result.toString().trim();
    }
}
