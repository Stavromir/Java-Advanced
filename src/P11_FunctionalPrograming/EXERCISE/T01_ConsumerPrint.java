package P11_FunctionalPrograming.EXERCISE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class T01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = p -> System.out.println(p);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(print);
    }
}
