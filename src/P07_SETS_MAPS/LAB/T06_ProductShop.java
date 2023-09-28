package P07_SETS_MAPS.LAB;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Double>> shopMap = new TreeMap<>();

        while (!"Revision".equals(input)) {

            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            shopMap.putIfAbsent(shop, new LinkedHashMap<>());
            shopMap.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : shopMap.entrySet()) {
            LinkedHashMap<String, Double> products = entry.getValue();

            System.out.println(entry.getKey() + "->");

            products.forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f%n", key, value));
        }
    }
}
