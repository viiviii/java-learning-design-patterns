package example._08_abstract_factory.factory;

public abstract class Link extends Item {

    protected final String url;

    protected Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
