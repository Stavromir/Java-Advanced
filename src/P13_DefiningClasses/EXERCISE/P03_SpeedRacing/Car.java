package P13_DefiningClasses.EXERCISE.P03_SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCoastPerKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCoastPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCoastPerKm = fuelCoastPerKm;
        this.distanceTraveled = 0;
    }

    public boolean enoughFuelAmount (int amountOfKm) {
        return fuelAmount >= neededFuel(amountOfKm);
    }

    public void driveCar (int amountOfKm) {
        fuelAmount -= neededFuel(amountOfKm);
        distanceTraveled += amountOfKm;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }

    private double neededFuel (int amountOfKm) {
        return fuelCoastPerKm * amountOfKm;
    }
}
