package example._01_iterator;

import java.util.Iterator;

class BookShelf implements Iterable<Book> {
    private final Book[] books;

    private int length = 0; // TODO: 변수명

    public BookShelf(int maxLength) {
        this.books = new Book[maxLength];
    }

    public void appendBook(Book book) {
        books[getLength()] = book;
        length += 1;
    }

    public int getLength() {
        return length;
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
