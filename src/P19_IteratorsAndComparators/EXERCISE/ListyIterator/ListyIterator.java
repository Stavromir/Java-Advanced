package P19_IteratorsAndComparators.EXERCISE.ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {

    private List<T> data;
    private int index;

    public ListyIterator() {
        this.data = new ArrayList<>();
        this.index = 0;
    }

    public void setData(List<T> dataArg) {
        this.data = dataArg;
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (this.index < data.size() - 1) {
            return true;
        }
        return false;
    }

    public void print() {
        if (!this.data.isEmpty()) {
            System.out.println(getElementAt(this.index));
        } else {
            throw new IllegalStateException("Invalid Operation!");
        }
    }

    private T getElementAt(int index) {
        return this.data.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<T> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < data.size();
        }

        @Override
        public T next() {
            return getElementAt(this.index++);
        }
    }
}
