package example._08_abstract_factory;

import example._08_abstract_factory.factory.Factory;
import example._08_abstract_factory.factory.Item;
import example._08_abstract_factory.factory.Page;
import example._08_abstract_factory.factory.Tray;

class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main [list | div]]");
            System.out.println("Example 1: java Main list");
            System.out.println("Example 2: java Main div");
            System.exit(0);
        }

        String name = args[0];

        Factory factory = Factory.getFactory(name);

        // Blog Site
        Tray blogTray = factory.createTray("Blog Site");
        Item blogLink1 = factory.createLink("Blog 1", "https://example.com/blog1");
        Item blogLink2 = factory.createLink("Blog 2", "https://example.com/blog2");
        Item blogLink3 = factory.createLink("Blog 3", "https://example.com/blog3");

        blogTray.add(blogLink1, blogLink2, blogLink3);

        // News Site
        Tray newsTray = factory.createTray("News Site");
        Item news1 = factory.createLink("News 1", "https://example.com/news1");
        Item news2 = factory.createLink("News 2", "https://example.com/news2");

        Tray news3 = factory.createTray("News 3");
        Item news3us = factory.createLink("News 3 (US)", "https://example.com/news3us");
        Item news3kr = factory.createLink("News 3 (Korea)", "https://example.com/news3kr");
        news3.add(news3us, news3kr);

        newsTray.add(news1, news2, news3);

        // Page
        Page page = factory.createPage("Blog and News", "Youngjin.com");
        page.add(blogTray, newsTray);
        page.output(name);
    }
}
