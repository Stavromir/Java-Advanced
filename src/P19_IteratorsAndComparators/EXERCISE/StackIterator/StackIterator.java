package P19_IteratorsAndComparators.EXERCISE.StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StackIterator<T> implements Iterable<T>{

    private List<T> data;

    public StackIterator() {
        this.data = new ArrayList<>();
    }

    public void push (T element) {
        this.data.add(element);
    }

    public void pop () {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("No elements");
        } else {
            this.data.remove(this.data.size() - 1);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<T> {

        int index = data.size() - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            return data.get(index--);
        }
    }
}
