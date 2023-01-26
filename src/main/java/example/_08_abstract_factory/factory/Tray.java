package example._08_abstract_factory.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

public abstract class Tray extends Item implements Iterable<Item> {

    private final List<Item> tray = new ArrayList<>();

    protected Tray(String caption) {
        super(caption);
    }

    public final void add(Item... items) {
        tray.addAll(asList(items));
    }

    @Override
    public final Iterator<Item> iterator() {
        return tray.iterator();
    }
}
