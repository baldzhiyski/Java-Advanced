package Exercise.Threeuple;

public class Threeuple<S,T,F>{
    private F item1;
    private T item2;
    private S item3;

    public Threeuple(F item1, T item2, S item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public F getItem1() {
        return item1;
    }

    public T getItem2() {
        return item2;
    }

    public S getItem3() {
        return item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", item1, item2,item3);
    }
}
