package example._08_abstract_factory.listfactory;

import example._08_abstract_factory.factory.Factory;
import example._08_abstract_factory.factory.Link;
import example._08_abstract_factory.factory.Page;
import example._08_abstract_factory.factory.Tray;

public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }

    @Override
    public Page createNaverPage() {
        final var page = new ListPage("Naver", "Naver");
        page.add(createLink("Naver", "https://www.naver.com/"));
        return page;
    }
}
