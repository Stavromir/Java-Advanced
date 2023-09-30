package P11_FunctionalPrograming.LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] words = input.split("\\s+");

        Predicate<String> isUpperLetter = s -> Character.isUpperCase(s.charAt(0));

        Function<String[], List<String>> uppercase = arr -> Arrays.stream(arr)
                .filter(isUpperLetter)
                .collect(Collectors.toList());

        List<String> upperCaseWords = uppercase.apply(words);

        System.out.println(upperCaseWords.size());

        Consumer<String> print = System.out::println;

        upperCaseWords.forEach(print);
    }
}
