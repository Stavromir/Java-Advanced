package P07_SETS_MAPS.LAB;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class T01_Parking_Lot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> parkingLot = new LinkedHashSet<>();

        while (!"END".equals(input)) {

            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            if (direction.equals("IN")) {
                parkingLot.add(carNumber);
            } else if (direction.equals("OUT")) {
                parkingLot.remove(carNumber);
            }
            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingLot.forEach(System.out::println);
        }
    }
}
