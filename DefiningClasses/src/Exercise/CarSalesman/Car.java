package Exercise.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;


    public Car(String carModel, Engine engine) {
        this.model = carModel;
        this.engine = engine;
        this.weight = -1; // invalid value
        this.color = "n/a";
    }

    public Car(String carModel, Engine engine, int weight) {
        this(carModel, engine);
        this.weight = weight;
    }

    public Car(String carModel, Engine engine, String color) {
        this(carModel, engine);
        this.color = color;
    }

    public Car(String carModel, Engine engine, int weight, String color) {
        this(carModel, engine, weight);
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":").append(System.lineSeparator());
        sb.append(this.engine);
        sb.append("Weight: ").append((this.weight == -1) ? "n/a" : this.weight).append(System.lineSeparator());
        sb.append("Color: ").append(this.color).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
