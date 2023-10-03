package Exercise.RawData;

public class Cargo {
    private String type;
    private int weight;

    public Cargo(int weight,String type) {
       this.weight=weight;
       this.type=type;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

}
