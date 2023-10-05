package P13_DefiningClasses.EXERCISE.P06_PokemonTrainer;

public class Trainer {

    private String trainerName;
    private int numOfBadges;
    private int collectOfPokemon;

    public Trainer(String trainerName) {
        this.trainerName = trainerName;
        this.collectOfPokemon = 0;
        this.numOfBadges = 0;
    }

    public void setNumOfBadges(int numOfBadges) {
        this.numOfBadges += numOfBadges;
    }

    public void setCollectOfPokemon(int collectOfPokemon) {
        this.collectOfPokemon += collectOfPokemon;
    }
}
