package example._08_abstract_factory.factory;

import example._08_abstract_factory.divfactory.DivFactory;
import example._08_abstract_factory.listfactory.ListFactory;

public abstract class Factory {

    public static Factory getFactory(String name) {
        // todo: 흠
        if ("list".equals(name)) {
            return new ListFactory();
        } else if ("div".equals(name)) {
            return new DivFactory();

        }
        throw new IllegalArgumentException();
    }

    public abstract Link createLink(String caption, String url);

    public abstract Tray createTray(String caption);

    public abstract Page createPage(String title, String author);
}
