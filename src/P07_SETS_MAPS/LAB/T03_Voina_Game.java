package P07_SETS_MAPS.LAB;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class T03_Voina_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerSet = readSet(scanner);

        Set<Integer> secondPlayerSet = readSet(scanner);

        int count = 0;

        while (count++ <= 50) {

            int firstPlayerCard = firstPlayerSet.iterator().next();
            firstPlayerSet.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayerSet.iterator().next();
            secondPlayerSet.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerSet.add(firstPlayerCard);
                firstPlayerSet.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerSet.add(secondPlayerCard);
                secondPlayerSet.add(firstPlayerCard);
            }

            if (firstPlayerSet.isEmpty() || secondPlayerSet.isEmpty()) {
                break;
            }
        }

        if (firstPlayerSet.size() > secondPlayerSet.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerSet.size() > firstPlayerSet.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    public static Set<Integer> readSet(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
