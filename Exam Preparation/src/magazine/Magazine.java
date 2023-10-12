package magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addCloth(Cloth cloth){
        if(isFree(data.size())){
            getData().add(cloth);
        }
    }
    public boolean removeCloth(String color){
        for (Cloth cloth : data) {
            if(cloth.getColor().equals(color)){
                data.remove(cloth);
                return true;
            }
        }
        return false;
    }
    public Cloth getSmallestCloth(){
        return data.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);
    }
    public Cloth getCloth(String color){
        return data.stream().filter(cloth -> cloth.getColor().equals(color)).findFirst().get();
    }
    public int getCount(){
        return this.data.size();
    }
    public String report(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s magazine contains:%n", type)).trimToSize();

        data.forEach(egg -> result.append(egg.toString()).append(String.format("%n")));

        return result.toString().trim();
    }
    public List<Cloth> getData() {
        return data;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }
    private boolean isFree(int size) {
        return size<capacity;
    }
}
