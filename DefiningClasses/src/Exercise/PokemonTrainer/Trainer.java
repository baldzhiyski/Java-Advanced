package Exercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> collectionOfPokemons;

    public Trainer(String name) {
        this.name = name;
        this.collectionOfPokemons = new ArrayList<>();
    }
    public void addToCollection(Pokemon pokemon){
        getCollectionOfPokemons().add(pokemon);
    }
    public void increaseBadge(){
        numberOfBadges++;
    }
    public boolean checkPokemon(String element){
        for (Pokemon pokemon : collectionOfPokemons) {
            if(pokemon.getElement().equals(element)){
                return true;
            }
        }
        return false;
    }
    public void decreaseHealth(){
        collectionOfPokemons.stream().forEach(pokemon->{
            pokemon.setHealth(pokemon.getHealth()-10);
        });
    }
    public void deleteIfNeeded(){
        collectionOfPokemons.removeIf(pokemon -> pokemon.getHealth()<=0);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getCollectionOfPokemons() {
        return collectionOfPokemons;
    }
}
