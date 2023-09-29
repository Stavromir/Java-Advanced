package P07_SETS_MAPS.EXERCISE;

import java.util.*;

public class T09_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System. in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Long>> countriesMap = new HashMap<>();
        Map<String, Long> populationCount = new LinkedHashMap<>();

        while (!"report".equals(input)) {

            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            long population = Long.parseLong(input.split("\\|")[2]);

            countriesMap.putIfAbsent(country, new LinkedHashMap<>());
            LinkedHashMap<String, Long> citiesMap = countriesMap.get(country);
            citiesMap.put(city, population);

            if (!populationCount.containsKey(country)) {
                populationCount.put(country, population);
            } else {
                populationCount.put(country, populationCount.get(country) + population);
            }
            input = scanner.nextLine();
        }

        populationCount.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> {

                    System.out.printf("%s (total population: %d)%n", entry.getKey(), entry.getValue());

                    Map<String, Long> cities = countriesMap.get(entry.getKey());

                    cities.entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
                            .forEach(innerEntry -> {
                                System.out.printf("=>%s: %d%n", innerEntry.getKey(), innerEntry.getValue());
                            });
                });
    }
}
