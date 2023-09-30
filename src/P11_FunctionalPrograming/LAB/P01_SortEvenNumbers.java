package P11_FunctionalPrograming.LAB;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        String evenNotSorted = outputString(numbers);
        System.out.println(evenNotSorted);

        List<Integer> evenSortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(outputString(evenSortedNumbers));
    }

    public static String outputString (List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
