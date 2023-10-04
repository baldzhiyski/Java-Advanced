package Exercise.CatLady;

public class Siamese extends Cat{
    private String type = "Siamese";
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize=earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return String.format("Siamese %s %.2f%n", getName(), getEarSize());
    }
}
