package P13_DefiningClasses.LAB.P01_CarInfoOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> garage = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];

            Car car;
            if (tokens.length > 1) {
                String model = tokens[1];
                int hp = Integer.parseInt(tokens[2]);
                car = new Car(brand, model, hp);
            } else {
                car = new Car(brand);
            }
            garage.add(car);
        }
        garage.forEach(System.out::println);
    }
}
