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

        var book = bookShelf.getBookAt(index);
        index += 1;
        return book;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }
}
