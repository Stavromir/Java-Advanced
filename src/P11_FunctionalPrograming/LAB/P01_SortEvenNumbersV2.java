package P11_FunctionalPrograming.LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P01_SortEvenNumbersV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        Function<List<Integer>, String> formatNum = l -> l.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        Function<List<Integer>, List<Integer>> sortNum = l -> l.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(formatNum.apply(numbers));
        System.out.println(formatNum.apply(sortNum.apply(numbers)));

//        List<Integer> evenSortedNumbers = numbers.stream()
//                .sorted()
//                .collect(Collectors.toList());

    }
}
