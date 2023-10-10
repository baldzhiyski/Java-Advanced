package Exercise.Tuple;

public class Tuple<F,T>{
    private F item1;
    private T item2;

    public Tuple(F item1, T item2) {
        setItem1(item1);
        setItem2(item2);
    }

    public F getItem1() {
        return item1;
    }

    public T getItem2() {
        return item2;
    }

    public void setItem1(F item1) {
        this.item1 = item1;
    }

    public void setItem2(T item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", item1, item2);
    }
}
