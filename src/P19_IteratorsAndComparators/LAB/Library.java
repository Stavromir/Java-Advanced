package P19_IteratorsAndComparators.LAB;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    private Book[] books;


    public Library(Book... books) {
        this.books = books;
    }

    private Book getBooksAt(int index) {
        return this.books[index];
    }

    @Override
    public Iterator<Book> iterator() {
        return new libIterator();
    }

    private class libIterator implements Iterator<Book> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < books.length;
        }

        @Override
        public Book next() {
            return getBooksAt(index++);
        }
    }
}
