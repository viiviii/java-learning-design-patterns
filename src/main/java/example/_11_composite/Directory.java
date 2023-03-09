package example._11_composite;

import java.util.ArrayList;
import java.util.List;

class Directory extends Entry {
    private final List<Entry> children = new ArrayList<>();

    Directory(String name) {
        super(name, 0);
    }

    @Override
    public int getSize() {
        return children.stream()
                .mapToInt(Entry::getSize)
                .sum();
    }

    @Override
    protected void printList(StringBuilder prefix) {
        System.out.println(prefix + "/" + this);

        prefix.append("/").append(getName());

        for (Entry child : children) {
            child.printList(prefix);
        }
    }

    public void add(Entry child) {
        children.add(child);
    }
}

