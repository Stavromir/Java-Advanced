package P15_Workshop.LAB;

import java.util.function.Consumer;

public class SmartArray<T> {

    private Object[] data;
    private int index;

    public SmartArray() {
        this.data = new Object[2];
        this.index = 0;
    }

    public void add(T element) {
        if (data.length == index) {
            data = resize(data.length * 2);
        }
        data[index] = element;
        index++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) this.data[index];
    }

    public void remove(int index) {

        Object[] newData = new Object[data.length];

        if (index == 0) {
            System.arraycopy(data, 1, newData, 0, this.index - 1);
        } else {
            System.arraycopy(data, 0, newData, 0, index);
            System.arraycopy(data, index + 1, newData, index, this.index - index);
        }
        data = newData;
        this.index--;
    }


    @SuppressWarnings("unchecked")
    public boolean contains(T element) {
        for (int i = 0; i < index; i++) {
            T currentElement = (T) data[i];
            if (currentElement == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, T element) {
        Object[] newData = new Object[data.length];

        if (index == 0) {
            newData[0] = element;
            System.arraycopy(data, 0, newData, 1, this.index);
        } else {
            System.arraycopy(data, 0, newData, 0, index);
            System.arraycopy(data, index, newData, index + 1, this.index - index);
            newData[index] = element;
        }
        data = newData;
        this.index++;
    }

    @SuppressWarnings("unchecked")
    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < index; i++) {
            consumer.accept((T)data[i]);
        }
    }

    private Object[] resize(int newSize) {
        Object[] newData = new Object[newSize];

        System.arraycopy(data, 0, newData, 0, index);

        return newData;
    }
}
