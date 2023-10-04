import java.util.function.Consumer;

public class SmartArray {
    private int[] elements;
    private int index;

    public SmartArray() {
        this.elements = new int[2];
        this.index = 0;
    }
    public void add(int element){
        if(index==elements.length){
            elements=resize(elements.length*2);
        }
        elements[index]=element;
        index++;
    }
    private int[] resize(int size) {
        int[] newArr = new int[size];
        for (int i = 0; i < this.index; i++) {
            newArr[i]=elements[i];
        }
        return newArr;
    }
    public int get(int index){
        return elements[index];
    }
    public boolean contains(int element){
        for (int num : elements) {
            if(num==element){
                return true;
            }
        }
        return false;
    }
    public int remove(int index){
        int itemToRemove = elements[index];
        shiftLeft(index);
        if(this.index==elements.length/4){
            elements=resize(elements.length/2);
        }
        return itemToRemove;
    }

    private void shiftLeft(int index) {
        for (int i = index; i <this.index-1 ; i++) {
            elements[i]=elements[i+1];
        }
        elements[this.index-1]=0;
        this.index--;
    }

    public void add(int index,int element){
        int lastItem = elements[this.index-1];
        shiftRight(index, element);
        add(lastItem);
    }

    private void shiftRight(int index, int element) {
        for (int i = this.index-1; i > index; i--) {
            elements[i]=elements[i-1];
        }
        elements[index]= element;
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < this.index; i++) {
            consumer.accept(elements[i]);
        }
    }
    public int size(){
        return index;
    }
}
