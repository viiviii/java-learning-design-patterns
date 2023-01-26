package example._08_abstract_factory;

import example._08_abstract_factory.factory.Factory;
import example._08_abstract_factory.factory.Item;
import example._08_abstract_factory.factory.Page;
import example._08_abstract_factory.factory.Tray;

class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: class.name.of.ConcreteFactory");
            System.out.println("Example 1: listfactory.ListFactory");
            System.out.println("Example 2: divfactory.DivFactory");
            System.exit(0);
        }

        String name = args[0];
        String packageRoot = Main.class.getPackage().getName();

        Factory factory = Factory.getFactory(packageRoot + "." + name);

        // Blog Site
        Item blog1 = factory.createLink("Blog 1", "https://example.com/blog1");
        Item blog2 = factory.createLink("Blog 2", "https://example.com/blog2");
        Item blog3 = factory.createLink("Blog 3", "https://example.com/blog3");

        Tray blogTray = factory.createTray("Blog Site");
        blogTray.add(blog1, blog2, blog3);

        // News Site
        Item news1 = factory.createLink("News 1", "https://example.com/news1");
        Item news2 = factory.createLink("News 2", "https://example.com/news2");

        Item news3us = factory.createLink("News 3 (US)", "https://example.com/news3us");
        Item news3kr = factory.createLink("News 3 (Korea)", "https://example.com/news3kr");
        Tray news3 = factory.createTray("News 3");
        news3.add(news3us, news3kr);

        Tray newsTray = factory.createTray("News Site");
        newsTray.add(news1, news2, news3);

        // Page
        Page page = factory.createPage("Blog and News", "Youngjin.com");
        page.add(blogTray, newsTray);

        page.output(name);
    }
}
