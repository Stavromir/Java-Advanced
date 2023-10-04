package P13_DefiningClasses.EXERCISE.P04_RawData;

import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private String model;
    private int enginePower;
    private String cargoType;
    private List<Double> tyresPressure;

    public Car(String model, int enginePower, String cargoType, List<Double> tyresPressure) {
        this.model = model;
        this.enginePower = enginePower;
        this.cargoType = cargoType;
        this.tyresPressure = tyresPressure;
    }

    public boolean checkLowTyrePressure () {
        return this.tyresPressure.stream()
                .anyMatch(e -> e < 1.0);
    }

    public boolean checkEnginePower () {
        return this.enginePower > 250;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s", model);
    }
}
