package example._01_iterator;

import java.util.Arrays;
import java.util.Iterator;

class BookShelf implements Iterable<Book> {
    private final Book[] books;

    private int length = 0; // TODO: 변수명

    public BookShelf(int maxLength) {
        this.books = new Book[maxLength];
    }

    // Iterator next()가 하는 일
    // - 집합체 요소를 1개 반환
    // - 내부 상태를 다음으로 진행시킴 (숨겨진 역할)
    public void appendBook(Book book) {
        books[getLength()] = book;
        length += 1;
    }

    public int getLength() {
        return length;
    }

    @Override
    public Iterator<Book> iterator() {
        return Arrays.stream(books).iterator();
    }
}
