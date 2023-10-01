package P11_FunctionalPrograming.EXERCISE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class T08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1 2 3 4 5 6
        //2 4 6 1 3 5

        Comparator<Integer> customComp = (first, second) -> {

            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            } else {
                return first.compareTo(second);
            }
        };

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(customComp)
                .forEach(e -> System.out.print(e + " "));
    }
}
