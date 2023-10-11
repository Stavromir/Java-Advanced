package P17_Generics.EXERCISE.P01_02_GenericBox;

public class GenericBox<T> {

    private T data;

    public GenericBox(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n", data.getClass().getName(), data);
    }
}
