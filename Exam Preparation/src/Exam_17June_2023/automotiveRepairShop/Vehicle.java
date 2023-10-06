package Exam_17June_2023.automotiveRepairShop;

public class Vehicle {
    private String VIN;
    private int mileage;
    private String damage;

    public Vehicle(String VIN, int mileage, String damage) {
        this.VIN = VIN;
        this.mileage = mileage;
        this.damage = damage;
    }

    public int getMileage() {
        return mileage;
    }

    public String getDamage() {
        return damage;
    }

    public String getVIN() {
        return VIN;
    }

    @Override
    public String toString() {
        return String.format("Damage: %s, Vehicle: %s (%d km)",this.damage,this.VIN,this.mileage);
    }
}
