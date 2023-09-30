package P11_FunctionalPrograming.LAB;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class P06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int lowerBound = Integer.parseInt(input.split("\\s+")[0]);
        int upperBound = Integer.parseInt(input.split("\\s+")[1]);
        String condition = scanner.nextLine();

        if (condition.equals("odd")) {
            printRange(lowerBound, upperBound, n -> n % 2 != 0);
        } else {
            printRange(lowerBound, upperBound, n -> n % 2 == 0);
        }
    }

    private static void printRange(int lowerBound, int upperBound, IntPredicate predicate) {
        IntStream.rangeClosed(lowerBound, upperBound)
                .filter(predicate)
                .forEach(n -> System.out.print(n + " "));
    }
}
