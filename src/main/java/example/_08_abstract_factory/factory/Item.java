package example._08_abstract_factory.factory;

public abstract class Item {
    
    protected final String caption;

    protected Item(String caption) {
        this.caption = caption;
    }

    public abstract String makeHTML();
}
