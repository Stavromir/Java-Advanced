package P07_SETS_MAPS.LAB;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] readArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> realNumbersCount = new LinkedHashMap<>();

        for (double current : readArray) {

            if (realNumbersCount.containsKey(current)) {
                realNumbersCount.put(current, realNumbersCount.get(current) + 1);
            } else {
                realNumbersCount.put(current, 1);
            }
        }

        realNumbersCount.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
