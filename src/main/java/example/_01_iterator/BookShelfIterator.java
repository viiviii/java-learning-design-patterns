package example._01_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

class BookShelfIterator implements Iterator<Book> {
    private final BookShelf bookShelf;

    private int index = 0;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        var current = bookShelf.getBookAt(index);
        index += 1;
        return current;
    }

    @Override
    public boolean hasNext() {
        return bookShelf.getLength() != index;
    }
}
