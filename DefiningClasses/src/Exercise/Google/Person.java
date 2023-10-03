package Exercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private  String name;
    private  Car car;
    private Company company;
    private List<Child> children;
    private List<Parent> parents;
    private List<Pokemon> pokemonsList;

    public Person(String name) {
        this.name = name;
        this.company=null;
        this.car=null;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.pokemonsList = new ArrayList<>();
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public List<Child> getChildren() {
        return children;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public List<Parent> getParents() {
        return parents;
    }
}
