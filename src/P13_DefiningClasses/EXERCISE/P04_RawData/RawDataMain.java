package P13_DefiningClasses.EXERCISE.P04_RawData;

import java.util.*;
import java.util.stream.Collectors;

public class RawDataMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Car>> garage = new LinkedHashMap<>();

        Car car;

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int enginePower = Integer.parseInt(input[2]);
            String cargoType = input[4];
            List<Double> tyresPressure = new ArrayList<>();
            for (int i = 5; i <= 11; i+=2) {
                double tyrePressure = Double.parseDouble(input[i]);
                tyresPressure.add(tyrePressure);
            }
            car = new Car(model,enginePower,cargoType,tyresPressure);
            garage.putIfAbsent(cargoType, new ArrayList<>());
            garage.get(cargoType).add(car);
        }

        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile"))  {
            garage.get(cargoType)
                    .stream()
                    .filter(Car::checkLowTyrePressure)
                    .forEach(System.out::println);
        } else {
//            garage.get(cargoType)
//                    .stream()
//                    .filter(Car::checkEnginePower)
//                    .forEach(System.out::println);

            garage.get(cargoType)
                    .stream()
                    .filter(e -> e.getEnginePower() > 250)
                    .forEach(System.out::println);
        }
    }
}
