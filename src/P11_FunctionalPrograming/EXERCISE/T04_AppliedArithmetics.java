package P11_FunctionalPrograming.EXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String inputCommand = scanner.nextLine();

        Consumer<List<Integer>> print = list -> list.forEach(p -> System.out.print(p + " "));

        while (!"end".equals(inputCommand)) {

            switch (inputCommand) {
                case "add":
                    numbers = commandApply(numbers, c -> c + 1);
                    break;
                case "multiply":
                    numbers = commandApply(numbers, c-> c * 2);
                    break;
                case "subtract":
                    numbers = commandApply(numbers, c -> c - 1);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            inputCommand = scanner.nextLine();
        }
    }

    public static List<Integer> commandApply(List<Integer> num, Function<Integer, Integer> command) {
        return num.stream()
                .map(command)
                .collect(Collectors.toList());
    }
}
