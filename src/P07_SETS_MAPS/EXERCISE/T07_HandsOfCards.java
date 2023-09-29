package P07_SETS_MAPS.EXERCISE;

import java.util.*;
import java.util.stream.Collectors;

public class T07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, HashSet<String>> playerMap = new LinkedHashMap<>();

        while (!"JOKER".equals(input)) {

            String name = input.split(": ")[0];
            String cards = input.split(": ")[1];
            String[] cardsArray = cards.split(", ");

            playerMap.putIfAbsent(name, new HashSet<>());
            for (String current : cardsArray) {
                playerMap.get(name).add(current);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, HashSet<String>> entry : playerMap.entrySet()) {
            HashSet<String> cards = entry.getValue();
            int sumaryPower = 0;

            for (String card : cards) {
                String power = card.substring(0, card.length() - 1);
                String type = card.substring(card.length() - 1);
                int powerOfCard = powerOfCard(power);
                int typeOfCard = typeOfCard(type);
                int summary = powerOfCard * typeOfCard;
                sumaryPower += summary;
            }

            System.out.printf("%s: %d%n", entry.getKey(), sumaryPower);
        }
    }

    private static int typeOfCard(String type) {
        int typeOfCard = 0;
        switch (type) {
            case "S":
                typeOfCard = 4;
                break;
            case "H":
                typeOfCard = 3;
                break;
            case "D":
                typeOfCard = 2;
                break;
            case "C":
                typeOfCard = 1;
                break;
        }
        return typeOfCard;
    }

    public static int powerOfCard(String power) {
        int powerOfCard = 0;
        switch (power) {
            case "J":
                powerOfCard = 11;
                break;
            case "Q":
                powerOfCard = 12;
                break;
            case "K":
                powerOfCard = 13;
                break;
            case "A":
                powerOfCard = 14;
                break;
            default:
                powerOfCard = Integer.parseInt(power);
        }
        return powerOfCard;
    }

}
