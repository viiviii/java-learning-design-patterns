package example._08_abstract_factory.factory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public abstract class Page {

    private final List<Item> contents = new ArrayList<>();

    protected final String title;
    protected final String author;

    protected Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public final void add(Item... item) {
        contents.addAll(asList(item));
    }

    public final List<Item> getContents() {
        return new ArrayList<>(contents);
    }

    public final void output(String name) {
        // 난 파일 구현 예제 대신 print 찍는 걸로 변경
        System.out.print(makeHTML());
    }

    public abstract String makeHTML();
}
