package CarConstructors;

public class Car {
    private String brand;

    public Car(String brand, String model, int hp) {
        setBrand(brand);
        setModel(model);
        setHp(hp);
    }
    public Car(String brand){
        this(brand,"unknown",-1);
    }
    private String model;
    private int hp;


    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.",this.getBrand(),this.getModel(),this.getHp());
    }

}
