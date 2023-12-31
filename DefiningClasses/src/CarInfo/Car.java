package CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public int getHorsePower() {
        return this.horsePower;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.",this.getBrand(),this.getModel(),this.getHorsePower());
    }
}
