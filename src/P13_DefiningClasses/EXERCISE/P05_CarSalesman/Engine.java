package P13_DefiningClasses.EXERCISE.P05_CarSalesman;

public class Engine {

    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public Engine(String model, String power) {
        this(model, power, "n/a", "n/a");
    }

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        setDisplacement(displacement);
        setEfficiency(efficiency);
    }

    @Override
    public String toString() {
        return String.format("%s:%n" + "Power: %s%n" + "Displacement: %s%n" + "Efficiency: %s%n",this.model, this.power
                , this.displacement, this.efficiency);
    }
}
