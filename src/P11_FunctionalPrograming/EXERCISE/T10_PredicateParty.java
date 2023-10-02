package P11_FunctionalPrograming.EXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class T10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> peopleList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"Party!".equals(input)) {

            String command = input.split("\\s+")[0];
            String criteria = input.split("\\s+")[1];
            String token = input.split("\\s+")[2];

            Predicate<String> filter = filter(criteria, token);

            switch (command) {
                case "Remove":
                    peopleList.removeIf(filter);
                    break;
                case "Double":
                    List<String> tempList = peopleList.stream()
                            .filter(filter)
                            .collect(Collectors.toList());

                    peopleList.addAll(tempList);
                    break;
            }
            input = scanner.nextLine();
        }

        if (peopleList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String output = peopleList.stream()
                    .sorted()
                    .collect(Collectors.joining(", "));

            System.out.println(output + " are going to the party!");
        }
    }

    public static Predicate<String> filter(String criteria, String token) {
        switch (criteria) {
            case "StartsWith":
                return e -> e.startsWith(token);
            case "EndsWith":
                return e -> e.endsWith(token);
            default:
                return e -> e.length() == Integer.parseInt(token);
        }
    }
}
