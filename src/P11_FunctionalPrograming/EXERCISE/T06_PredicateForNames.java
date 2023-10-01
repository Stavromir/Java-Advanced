package P11_FunctionalPrograming.EXERCISE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class T06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<String> checkNameLength = str -> str.length() <= n;
        Consumer<String> print = System.out::println;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(checkNameLength)
                .forEach(print);
    }
}
