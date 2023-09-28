package P07_SETS_MAPS.LAB;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class T09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));

        NavigableSet<Integer> reversedSet = numbers.descendingSet();

        int count = 0;

        while (count++ < 3) {
            if (reversedSet.isEmpty()) {
                break;
            }
            int currentNum = reversedSet.iterator().next();
            reversedSet.remove(currentNum);
            System.out.print(currentNum + " ");
        }
    }
}
