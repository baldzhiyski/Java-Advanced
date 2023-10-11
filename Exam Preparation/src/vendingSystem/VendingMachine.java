package vendingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }
    public void addDrink(Drink drink){
        if(availableSpots(drinks.size())){
            getDrinks().add(drink);
        }
    }
    public boolean removeDrink(String name){
        for (Drink drink : drinks) {
            if(drink.getName().equals(name)){
                drinks.remove(drink);
                return true;
            }
        }
        return false;
    }
    public int getCount(){
        return drinks.size();
    }
    public Drink getLongest(){
        return this.drinks.stream().max(Comparator.comparingInt(Drink::getVolume)).orElse(null);
    }
    public Drink getCheapest(){
        return this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
    }
    public String buyDrink(String name){
        return drinks.stream().filter(drink -> drink.getName().equals(name)).findFirst().get().toString();
    }
    public String report(){
        StringBuilder result = new StringBuilder();
        result.append("Drinks available:");
        result.append(System.lineSeparator());
        drinks.stream().forEach(drink -> result.append(drink + System.lineSeparator()));
        return result.toString();
    }
    public List<Drink> getDrinks() {
        return drinks;
    }

    private boolean availableSpots(int size) {
        return size<buttonCapacity;
    }
}
