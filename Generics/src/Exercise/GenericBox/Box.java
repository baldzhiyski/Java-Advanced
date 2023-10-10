package Exercise.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable>{

    private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }
    public String toString(){
        return String.format("%s: %s",this.data.getClass().getName(),data);
    }
    public void add(T element) {
        data.add(element);
    }
    public int countOfGreaterItems(T element) {
        int counter = 0;
        for (T e : this.data) {
            int res = e.compareTo(element);
            if(res>0){
                counter++;
            }
        }
        return counter;
    }
}
