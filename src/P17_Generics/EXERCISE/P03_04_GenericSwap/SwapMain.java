package P17_Generics.EXERCISE.P03_04_GenericSwap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SwapMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> list = new ArrayList<>();

        while (n-- > 0){
            Integer input = Integer.parseInt(scanner.nextLine());

            list.add(input);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Swap.swapPositions(list, indexes[0], indexes[1]);

        list.stream()
                .forEach(each -> System.out.printf("%s: %s%n", each.getClass().getName(), each));
    }
}
