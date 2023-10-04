package Exercise.CatLady;

public class StreetExtraordinaire  extends  Cat{
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name,String type, double decibelsOfMeows) {
        super(name,type);
        this.decibelsOfMeows=decibelsOfMeows;
    }
    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    public void setDecibelsOfMeows(double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }
    @Override
    public String toString() {
        return String.format("%s %.2f%n",super.toString(), getDecibelsOfMeows());
    }
}
