package P13_DefiningClasses.EXERCISE.P05_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public String getModel() {
        return this.model;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, "n/a", "n/a");
    }

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        setWeight(weight);
        setColor(color);
    }

    @Override
    public String toString() {
        return String.format("%s:%n" + "%s" + "Weight: %s%n" + "Color: %s%n",this.model,engine.toString()
                , this.weight, this.color);
    }
}
