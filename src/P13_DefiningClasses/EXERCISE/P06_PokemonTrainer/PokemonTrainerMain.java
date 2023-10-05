package P13_DefiningClasses.EXERCISE.P06_PokemonTrainer;

import java.util.*;

public class PokemonTrainerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Trainer trainer;
        Pokemon pokemon;

        Map<String, List<Pokemon>> trainersPokemon = new HashMap<>();
        Map<String, List<Trainer>> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String trainerName = input.split("\\s+")[0];
            String pokemonName = input.split("\\s+")[1];
            String pokemonElement = input.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(input.split("\\s+")[3]);

            pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainersPokemon.putIfAbsent(trainerName, new ArrayList<>());
            trainersPokemon.get(trainerName).add(pokemon);
            trainer = new Trainer(trainerName);
            trainers.putIfAbsent(trainerName, new ArrayList<>());
            trainers.get(trainerName).add(trainer);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();


        while (!input.equals("End")) {

            String command = input;

            trainersPokemon.entrySet()
                    .stream()
                    .forEach(entry -> {

                        entry.getValue().stream()
                                .forEach(poke -> {
                                    if (poke.checkElement(command)) {

                                    }
                                });
                    });





            input = scanner.nextLine();
        }


    }


}
