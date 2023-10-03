package Exercise.RawData;

public class Car {
    private  String model;
    private Cargo cargo;
    private  Engine engine;
    private Tires tires;


    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
        this.model = model;
        this.cargo = new Cargo(cargoWeight,cargoType);
        this.engine = new Engine(engineSpeed,enginePower);
        this.tires = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tires getTires() {
        return tires;
    }
}
