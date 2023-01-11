package example._01_iterator;

import java.util.Iterator;

class BookShelf implements Iterable<Book> {
    private final Book[] books;

    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public void appendBook(Book book) {
        books[last] = book;
        last += 1;
    }

    public int getLength() {
        return last;
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
