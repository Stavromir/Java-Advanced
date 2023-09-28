package P07_SETS_MAPS.EXERCISE;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class T03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] inputText = scanner.nextLine().split("\\s+");

            for (String current : inputText) {
                elements.add(current);
            }
        }

        String print = String.join(" ", elements);
        System.out.print(print);
    }
}
