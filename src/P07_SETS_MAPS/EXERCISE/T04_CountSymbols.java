package P07_SETS_MAPS.EXERCISE;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        Map<Character, Integer> charCount = new TreeMap<>();

        for (int i = 0; i < inputText.length(); i++) {
                char current = inputText.charAt(i);

                if (!charCount.containsKey(current)) {
                    charCount.put(current, 1);
                } else {
                    charCount.put(current, charCount.get(current) + 1);
                }

        }

        charCount.forEach((k, v) -> System.out.printf("%s: %d time/s%n", k, v));
    }
}
