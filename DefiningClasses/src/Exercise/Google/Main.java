package Exercise.Google;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        LinkedHashMap<String,Person> personMap = new LinkedHashMap<>();
        while (!command.equals("End")){
            String[] data = command.split("\\s+");
            String word = data[1];
            String personName = data[0];
            Person currentPerson;
            if (!personMap.containsKey(personName)) {
                personMap.put(personName, new Person(personName));
            }
            currentPerson = personMap.get(personName);
            if(word.equals("company")){
                executeCompany(data, currentPerson);
            }else if(word.equals("pokemon")){
                executePokemon(data, currentPerson);
            }else if(word.equals("parents")){
                executeParent(data, currentPerson);
            }else if(word.equals("children")){
                executeChild(data, currentPerson);
            }else if(word.equals("car")){
                executeCar(data, currentPerson);
            }
            command=scan.nextLine();
        }
        String personToPrint = scan.nextLine();
        print(personMap,personToPrint);
    }

    private static void executeCar(String[] data, Person currentPerson) {
        String carModel = data[2];
        String carSpeed = data[3];
        Car car = new Car(carModel,carSpeed);
        currentPerson.setCar(car);
    }

    private static void executeChild(String[] data, Person currentPerson) {
        String childName = data[2];
        String birthday = data[3];
        Child child = new Child(childName,birthday);
        currentPerson.getChildren().add(child);
    }

    private static void executeParent(String[] data, Person currentPerson) {
        String parentName = data[2];
        String birthday = data[3];
        Parent parent = new Parent(parentName,birthday);
        currentPerson.getParents().add(parent);
    }

    private static void executePokemon(String[] data, Person currentPerson) {
        String pokemonName = data[2];
        String type = data[3];
        Pokemon pokemon = new Pokemon(pokemonName,type);
        currentPerson.getPokemonsList().add(pokemon);
    }

    private static void executeCompany(String[] data, Person currentPerson) {
        String companyName = data[2];
        String department = data[3];
        double salary = Double.parseDouble(data[4]);
        Company company = new Company(companyName,department,salary);
        currentPerson.setCompany(company);
    }

    private static void print(LinkedHashMap<String, Person> personMap, String person) {
        System.out.printf("%s%n", personMap.get(person).getName());
        System.out.printf("Company:%n");
        if (personMap.get(person).getCompany() != null) {
            System.out.printf("%s %s %.2f%n", personMap.get(person).getCompany().getName(), personMap.get(person).getCompany().getDepartment(), personMap.get(person).getCompany().getSalary());
        }
        System.out.printf("Car:%n");
        if (personMap.get(person).getCar() != null) {
            System.out.printf("%s %s%n", personMap.get(person).getCar().getName(),personMap.get(person).getCar().getSpeed());
        }
        System.out.printf("Pokemon:%n");
        if (personMap.get(person).getPokemonsList() != null) {
            for (Pokemon pokemon : personMap.get(person).getPokemonsList()) {
                System.out.printf("%s %s%n", pokemon.getName(), pokemon.getType());
            }
        }
        System.out.printf("Parents:%n");
        if (personMap.get(person).getParents() != null) {
            for (Parent parent : personMap.get(person).getParents()) {
                System.out.printf("%s %s%n", parent.getName(), parent.getBirthday());
            }
        }
        System.out.printf("Children:%n");
        if (personMap.get(person).getChildren() != null) {
            for (Child child : personMap.get(person).getChildren()) {
                System.out.printf("%s %s%n", child.getName(), child.getBirthday());
            }
        }
    }
}
