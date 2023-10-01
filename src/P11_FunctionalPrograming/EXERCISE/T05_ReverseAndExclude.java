package P11_FunctionalPrograming.EXERCISE;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class T05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> filterByN = i -> i % n != 0;

        Consumer<List<Integer>> print = list -> list.forEach(p -> System.out.print(p + " "));

        numbers = numbers.stream()
                .filter(filterByN)
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        print.accept(numbers);
    }
}
