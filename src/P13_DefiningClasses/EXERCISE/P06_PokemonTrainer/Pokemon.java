package P13_DefiningClasses.EXERCISE.P06_PokemonTrainer;

public class Pokemon {

    private String pokemonName;
    private String element;
    private int health;

    public Pokemon(String pokemonName, String element, int health) {
        this.pokemonName = pokemonName;
        this.element = element;
        this.health = health;
    }

    public boolean checkElement (String element) {
        return this.element.equals(element) && this.health > 0;
    }

    public boolean deadPokemon () {
        return this.health <= 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
