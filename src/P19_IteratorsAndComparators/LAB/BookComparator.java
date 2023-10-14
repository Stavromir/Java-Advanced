package P19_IteratorsAndComparators.LAB;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {


    @Override
    public int compare(Book firstBook, Book secondBook) {
        return firstBook.compareTo(secondBook);
    }
}
