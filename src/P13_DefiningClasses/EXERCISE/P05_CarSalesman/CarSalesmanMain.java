package P13_DefiningClasses.EXERCISE.P05_CarSalesman;

import java.util.*;

public class CarSalesmanMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engineMap = new HashMap<>();
        Set<Car> carSet = new LinkedHashSet<>();

        Engine engine;
        Car car;

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String power = input[1];

            switch (input.length) {
                case 4:
                    String displacement = input[2];
                    String efficiency = input[3];
                    engine = new Engine(model, power,displacement, efficiency);
                    engineMap.put(model, engine);
                    break;
                case 3:
                    engine = new Engine(model, power);
                    if (input[2].matches("\\d+")) {
                         displacement = input[2];
                        engine.setDisplacement(displacement);
                        engineMap.put(model, engine);
                    } else {
                        efficiency = input[2];
                        engine.setEfficiency(efficiency);
                        engineMap.put(model, engine);
                    }
                    break;
                default:
                    engine = new Engine(model, power);
                    engineMap.put(model, engine);
                    break;
            }

        }

        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String engineModel = input[1];
            engine = engineMap.get(engineModel);

            switch (input.length) {
                case 4:
                    String weigh = input[2];
                    String color = input[3];
                    car = new Car(model, engine, weigh, color);
                    carSet.add(car);
                    break;
                case 3:
                    if (input[2].matches("\\d+")) {
                        weigh = input[2];
                        car = new Car(model, engine);
                        car.setWeight(weigh);
                        carSet.add(car);
                    } else {
                        color = input[2];
                        car = new Car(model, engine);
                        car.setColor(color);
                        carSet.add(car);
                    }
                    break;
                default:
                    car = new Car(model, engine);
                    carSet.add(car);
                    break;
            }
        }
        carSet.forEach(System.out::print);
    }
}
