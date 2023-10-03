package Exercise.CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
    public Engine(String model, int power) {
       this(model,power,-1,"n/a");
    }
    public Engine(String engineModel, int power, int displacement) {
        this(engineModel, power,displacement,"n/a");
    }

    public Engine(String engineModel, int power, String efficiency) {
        this(engineModel, power,-1,efficiency);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":").append(System.lineSeparator());
        sb.append("Power: ").append(this.power).append(System.lineSeparator());
        sb.append("Displacement: ").append((this.displacement == -1) ? "n/a" : this.displacement).append(System.lineSeparator());
        sb.append("Efficiency: ").append(this.efficiency).append(System.lineSeparator());
        return sb.toString();
    }

}
