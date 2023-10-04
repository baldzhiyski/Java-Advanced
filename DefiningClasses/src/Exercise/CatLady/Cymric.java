package Exercise.CatLady;

public class Cymric extends  Cat{
    private double furLength;
    public Cymric(String name,String type, double furLength) {
        super(name,type);
        this.furLength=furLength;
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }
    @Override
    public String toString() {
        return String.format("%s %.2f%n",super.toString(), getFurLength());
    }
}
