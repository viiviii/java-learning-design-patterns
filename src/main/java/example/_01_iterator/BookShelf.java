package example._01_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class BookShelf implements Iterable<Book> {
    private final List<Book> books;

    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new ArrayList<>(maxSize);
    }

    public void appendBook(Book book) {
        books.add(last, book);
        last += 1;
    }

    public int getLength() {
        return last;
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
