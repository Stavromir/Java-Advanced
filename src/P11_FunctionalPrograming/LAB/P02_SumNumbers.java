package P11_FunctionalPrograming.LAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], String> countNum = arr -> "Count = " + arr.length;
        Function<int[], String> sumNum = arr -> "Sum = " + Arrays.stream(arr).sum();

        System.out.println(countNum.apply(numbers));
        System.out.println(sumNum.apply(numbers));
    }
}
