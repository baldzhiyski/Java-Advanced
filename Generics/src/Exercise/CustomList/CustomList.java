package Exercise.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T>{
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }
    public void add(T element){
        this.list.add(element);
    }
    public T remove(int index){
        checkIndex(index);
        return this.list.remove(index);
    }
    public int size(){
        return list.size();
    }
    public T get(int index){
        return list.get(index);
    }
    public boolean contains(T element){
        return this.list.contains(element);
    }
    public void swap(int firstIndex , int secondIndex){
        Collections.swap(this.list,firstIndex,secondIndex);
    }
    public int countGreaterThan(T element){
        int counter = 0;
        for (T e : this.list) {
            int res = e.compareTo(element);
            if(res>0){
                counter++;
            }
        }
        return counter;
    }
    public T getMax(){
        checkEmpty();
       return Collections.max(this.list);
    }


    public T getMin(){
        checkEmpty();
        return Collections.min(this.list);
    }
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index< list.size();
            }

            @Override
            public T next() {
                return list.get(index++);
            }
        };

    }
    private void checkEmpty() {
        if(this.list.isEmpty()){
            throw new IllegalStateException("List is empty!");
        }
    }
    private void checkIndex(int index) {
        if(index<0 || index>this.list.size()){
            throw new IndexOutOfBoundsException("Invalid index !");
        }
    }
}
