package P07_SETS_MAPS.LAB;

import java.util.*;
import java.util.stream.Collectors;

public class T09_Largest3NumbersV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        int count = 0;

        while (count++ < 3) {
            if (numbers.isEmpty()) {
                break;
            }
            int currentNum = numbers.get(0);
            numbers.remove(0);
            System.out.print(currentNum + " ");
        }
    }
}
