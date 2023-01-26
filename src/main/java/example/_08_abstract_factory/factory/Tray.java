package example._08_abstract_factory.factory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public abstract class Tray extends Item {

    protected final List<Item> tray = new ArrayList<>(); // todo

    protected Tray(String caption) {
        super(caption);
    }

    public void add(Item... items) {
        tray.addAll(asList(items));
    }
}
