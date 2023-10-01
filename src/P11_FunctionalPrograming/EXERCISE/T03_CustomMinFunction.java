package P11_FunctionalPrograming.EXERCISE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class T03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findSmallestNum = arr -> {
            return Arrays.stream(arr)
                    .min(Integer::compareTo)
                    .get();
        };

        Integer[] num = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int smallestNum = findSmallestNum.apply(num);
        System.out.println(smallestNum);
    }
}
