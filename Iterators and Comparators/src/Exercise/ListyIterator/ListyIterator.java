package Exercise.ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator<T>  implements Iterable<T>{
    private List<T> elements;
    private int currentIndex;

    public ListyIterator(T... elements) {
        setElements(elements);
        this.currentIndex=0;
    }

    public void setElements(T... elements) {
        this.elements = List.of(elements);
    }

    public List<T> getElements() {
        return elements;
    }
    public boolean move(){
        if(currentIndex + 1 <elements.size()){
            currentIndex++;
            return true;
        }
        return false;
    }
    public boolean hasNext(){
        return currentIndex+1<elements.size();
    }
    public void print(){
        try{
           System.out.println(elements.get(currentIndex));
        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("Invalid Operation!");
        }

    }

    @Override
    public Iterator<T> iterator() {
        return  new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index<elements.size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };
    }
}
