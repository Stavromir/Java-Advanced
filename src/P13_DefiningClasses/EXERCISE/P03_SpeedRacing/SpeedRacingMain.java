package P13_DefiningClasses.EXERCISE.P03_SpeedRacing;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SpeedRacingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        Car car;

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCoastPerKm = Double.parseDouble(input[2]);

            car = new Car(model, fuelAmount, fuelCoastPerKm);

            cars.putIfAbsent(model, car);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String model = command.split("\\s+")[1];
            int amountOfKm = Integer.parseInt(command.split("\\s+")[2]);

            car = cars.get(model);

            if (car.enoughFuelAmount(amountOfKm)) {
                car.driveCar(amountOfKm);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine();
        }

        cars.values()
                .stream()
                .forEach(System.out::println);
    }
}
