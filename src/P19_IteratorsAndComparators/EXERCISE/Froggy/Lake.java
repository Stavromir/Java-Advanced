package P19_IteratorsAndComparators.EXERCISE.Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private Integer[] data;
    private int startingIndex;

    public Lake(Integer[] data) {
        this.data = data;
    }

    public int getSize () {
        return data.length;
    }

    public void setIndex(int index) {
        this.startingIndex = index;
    }

    private int getAtIndex(int index) {
        return this.data[index];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        int index = startingIndex;

        @Override
        public boolean hasNext() {
            return index < data.length;
        }

        @Override
        public Integer next() {
            int indexToPrint = index;
            index += 2;
            return getAtIndex(indexToPrint);
        }

    }
}
