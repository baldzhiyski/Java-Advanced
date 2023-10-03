package Exercise.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        String firstRoll = scan.nextLine();

        while (!firstRoll.equals("Tournament")) {
            String[] data = firstRoll.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            trainerMap.putIfAbsent(trainerName, new Trainer(trainerName));
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerMap.get(trainerName).addToCollection(pokemon);

            firstRoll = scan.nextLine();
        }
        String secondRoll = scan.nextLine();
        while (!secondRoll.equals("End")) {
            String element = secondRoll;
            for (Map.Entry<String, Trainer> trainer : trainerMap.entrySet()) {
                if (!trainer.getValue().checkPokemon(element)) {
                    trainer.getValue().decreaseHealth();
                    trainer.getValue().deleteIfNeeded();
                } else {
                    trainer.getValue().increaseBadge();
                }
            }
            secondRoll = scan.nextLine();
        }
        trainerMap.entrySet().stream().sorted((trainer1,trainer2)->Integer
                        .compare(trainer2.getValue().getNumberOfBadges(),trainer1.getValue().getNumberOfBadges()))
                .forEach(trainer-> System.out.printf("%s %d %d\n",trainer.getKey()
                ,trainer.getValue().getNumberOfBadges(),trainer.getValue().getCollectionOfPokemons().size()));
    }
}
