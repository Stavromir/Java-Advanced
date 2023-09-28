package P07_SETS_MAPS.LAB;

import java.util.*;

public class T07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> countriesDataByContinent = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputText = scanner.nextLine().split("\\s+");
            String continent = inputText[0];
            String country = inputText[1];
            String city = inputText[2];

//            Europe:
//            Bulgaria -> Sofia, Plovdiv
//            Poland -> Warsaw, Poznan
//            Germany -> Berlin

            countriesDataByContinent.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> countryData = countriesDataByContinent.get(continent);
            countryData.putIfAbsent(country, new ArrayList<>());
            countryData.get(country).add(city);
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> mapEntry : countriesDataByContinent.entrySet()) {
            System.out.printf("%s:%n", mapEntry.getKey());

            LinkedHashMap<String, List<String>> countryMap = mapEntry.getValue();

            for (Map.Entry<String, List<String>> entry : countryMap.entrySet()) {
                List<String> cityList = entry.getValue();

                System.out.print(entry.getKey() + " -> ");

                String cities = String.join(", ",cityList);
                System.out.println(cities);
            }
        }
    }
}
