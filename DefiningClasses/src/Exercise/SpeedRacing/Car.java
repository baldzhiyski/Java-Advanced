package Exercise.SpeedRacing;

public class Car {
    String model;
    double fuel;
    double fuelCostFor1Km;
    long distanceTraveled = 0;

    public Car(String model, long fuel, double fuelCostFor1Km) {
        setModel(model);
        setFuel(fuel);
        setFuelCostFor1Km(fuelCostFor1Km);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
    public void reduceFuelAmount(long km){
        fuel-=km*fuelCostFor1Km;
    }

    public void setFuelCostFor1Km(double fuelCostFor1Km) {
        this.fuelCostFor1Km = fuelCostFor1Km;
    }
    public boolean checkKm(long km){
        return fuel/fuelCostFor1Km >= km;
    }

    public void addDistance(long distance) {
        distanceTraveled += distance;
    }
}
