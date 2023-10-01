package P11_FunctionalPrograming.EXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Integer> indexOfSmallestNum = list -> {

            int indexOfSmallest = 0;

            for (int i = 1; i < list.size(); i++) {

                if (list.get(i) <= list.get(i - 1)) {
                    indexOfSmallest = i;
                }
            }
            return indexOfSmallest;
        };


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int index = indexOfSmallestNum.apply(numbers);
        System.out.println(index);
    }
}
