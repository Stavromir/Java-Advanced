package P07_SETS_MAPS.EXERCISE;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class T02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split("\\s+")[0]);
        int m = Integer.parseInt(input.split("\\s+")[1]);

        for (int i = 0; i < n; i++) {
            String current = scanner.nextLine();
            firstSet.add(current);
        }
        for (int j = 0; j < m; j++) {
            String current = scanner.nextLine();
            secondSet.add(current);
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
