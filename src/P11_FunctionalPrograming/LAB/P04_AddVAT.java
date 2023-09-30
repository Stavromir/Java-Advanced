package P11_FunctionalPrograming.LAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Consumer<Double> print = d -> System.out.printf("%.2f%n", d);

        Function<String, Double> parseWithAddVAT = d -> Double.parseDouble(d) * 1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(input.split(", "))
                .map(parseWithAddVAT)
                .forEach(print);
    }
}
