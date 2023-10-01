package P11_FunctionalPrograming.EXERCISE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printPlus = p -> System.out.printf("Sir %s%n",p);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(printPlus);
    }
}
