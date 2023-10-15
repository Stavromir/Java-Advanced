package P19_IteratorsAndComparators.EXERCISE.Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FroggyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] arr = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Lake lake = new Lake(arr);

        String input = scanner.nextLine();

        List<Integer> output = new ArrayList<>();

        for (int i = 0; i <= 1; i++) {
            lake.setIndex(i);
            lake.forEach(output::add);
        }

        for (int i = 0; i < output.size() - 1; i++) {
            System.out.print(output.get(i) + ", ");
        }
        System.out.print(output.get(output.size() - 1));

    }
}
