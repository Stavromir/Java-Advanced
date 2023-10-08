package P15_Workshop.LAB;

import java.util.Scanner;
import java.util.function.Consumer;

public class SmartArray {

    private int[] data;
    private int index;

    public SmartArray() {
        this.data = new int[2];
        this.index = 0;
    }

    public void add(int element) {
        if (this.data.length == index) {
            data = resize(data.length * 2);
        }
        this.data[index] = element;
        index++;
    }

    public int get(int index) {
        return this.data[index];
    }

    public void remove(int index) {

        int[] newData = new int[this.data.length];

        if (index == 0) {
            System.arraycopy(data, 1, newData, 0, this.index - 1);
        } else {
            System.arraycopy(data, 0, newData, 0, index);
            System.arraycopy(data, index + 1, newData, index, this.index - index);
        }
        data = newData;
        this.index--;
    }

    public boolean contains (int element) {
        for (int i = 0; i < index; i++) {
            int currentElement = data[i];
            if (currentElement == element) {
                return true;
            }
        }
        return false;
    }

    public void add (int index, int element) {
        int[] newData = new int[data.length];

        if (index == 0) {
            newData[0] = element;
            System.arraycopy(data, 0, newData, 1, this.index);
        } else {
            System.arraycopy(data, 0, newData, 0, index);
            System.arraycopy(data, index, newData, index + 1, this.index - index );
            newData[index] = element;
        }
        data = newData;
        this.index++;
    }

    public void forEach (Consumer<Integer> consumer) {
        for (int i = 0; i < index; i++) {
            consumer.accept(data[i]);
        }
    }

    private int[] resize(int newSize) {
        int[] newData = new int[newSize];

        System.arraycopy(data, 0, newData, 0, index);

        return newData;
    }
}
