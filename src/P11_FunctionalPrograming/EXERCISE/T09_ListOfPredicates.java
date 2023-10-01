package P11_FunctionalPrograming.EXERCISE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class T09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> predicateNum = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> finalList = IntStream.rangeClosed(1, n)
                .boxed().collect(Collectors.toList());

        Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));

        for (Integer pr : predicateNum) {
            Predicate<Integer> predicate = p -> p % pr == 0;

            finalList = finalList.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
        }

        print.accept(finalList);
    }
}
