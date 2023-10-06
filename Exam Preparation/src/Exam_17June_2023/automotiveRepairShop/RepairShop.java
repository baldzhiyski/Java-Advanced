package Exam_17June_2023.automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void addVehicle(Vehicle vehicle){
        if(this.vehicles.size()<capacity){
            getVehicles().add(vehicle);
        }
    }
    public boolean removeVehicle(String vin){
        for (Vehicle vehicle : this.vehicles) {
            if(vehicle.getVIN().equals(vin)){
                this.vehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }
    public int getCount(){
        return this.vehicles.size();
    }
    public Vehicle getLowestMileage(){
        Comparator<Vehicle> comparator = (v1,v2)->Integer.compare(v1.getMileage(),v2.getMileage());
        return this.vehicles.stream().min(comparator).get();
    }
    public String report(){
        StringBuilder result = new StringBuilder();
        result.append("Vehicles in the preparatory:");
        result.append(System.lineSeparator());
        this.vehicles.forEach(vehicle -> result.append(vehicle.toString()+ System.lineSeparator()));
        return result.toString();
    }
}
