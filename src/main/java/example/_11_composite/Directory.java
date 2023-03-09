package example._11_composite;

import java.util.ArrayList;
import java.util.List;

class Directory extends Entry {

    private final String name;
    private final List<Entry> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(Entry child) {
        children.add(child);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return children.stream()
                .mapToInt(Entry::getSize)
                .sum();
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);

        for (Entry child : children) {
            child.printList(prefix + "/" + getName());
        }
    }
}

