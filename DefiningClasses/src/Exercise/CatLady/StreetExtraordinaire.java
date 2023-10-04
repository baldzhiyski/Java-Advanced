package Exercise.CatLady;

public class StreetExtraordinaire  extends  Cat{
    private String type = "StreetExtraordinaire";
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows=decibelsOfMeows;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    public void setDecibelsOfMeows(double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }
    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f%n", getName(), getDecibelsOfMeows());
    }
}
