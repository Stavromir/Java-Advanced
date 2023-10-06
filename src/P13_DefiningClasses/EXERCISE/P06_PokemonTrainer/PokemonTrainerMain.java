package P13_DefiningClasses.EXERCISE.P06_PokemonTrainer;

import java.util.*;

public class PokemonTrainerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Trainer trainer;
        Pokemon pokemon;

        Map<String, List<Pokemon>> trainersPokemon = new HashMap<>();
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String trainerName = input.split("\\s+")[0];
            String pokemonName = input.split("\\s+")[1];
            String pokemonElement = input.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(input.split("\\s+")[3]);

            pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainersPokemon.putIfAbsent(trainerName, new ArrayList<>());
            trainersPokemon.get(trainerName).add(pokemon);
            trainer = new Trainer(trainerName);
            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).setCollectOfPokemon(1);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();


        while (!input.equals("End")) {

            String command = input;

            trainersPokemon.entrySet()
                    .stream()
                    .forEach(entry -> {

                        String trainerName = entry.getKey();

                        boolean containsPoke = entry.getValue().stream()
                                .anyMatch(e -> e.checkElement(command));

                        if (containsPoke) {
                            trainers.get(trainerName).setNumOfBadges(1);
                        } else {
                            entry.getValue()
                                    .stream()
                                    .forEach(e -> {
                                        int health = e.getHealth();
                                        if (health > 0) {
                                            e.setHealth(health - 10);
                                        }
                                    });
                        }
                    });
            input = scanner.nextLine();
        }

        trainersPokemon.entrySet()
                        .stream()
                                .forEach(entry -> {
                                    String trainerName = entry.getKey();
                                    List<Pokemon> poke = entry.getValue();

                                    for (Pokemon pokemon1 : poke) {
                                        if (pokemon1.deadPokemon()) {
                                            trainers.get(trainerName).setCollectOfPokemon(-1);
                                        }
                                    }
                                });

        trainers.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue().getNumOfBadges(), a.getValue().getNumOfBadges()))
                .forEach(e -> System.out.println(e.getValue().toString()));
    }
}
