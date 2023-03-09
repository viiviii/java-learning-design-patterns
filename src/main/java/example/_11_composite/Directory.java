package example._11_composite;

import java.util.ArrayList;
import java.util.List;

class Directory {
    private final String name;
    private final List<Directory> children = new ArrayList<>();

    Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return 0;
    }

    public void printList() {
        final var prefix = new StringBuilder();

        printList(prefix, this);

        for (Directory child : children) {
            printList(prefix, child);
        }
    }

    private void printList(StringBuilder prefix, Directory directory) {
        prefix.append("/");
        System.out.println(prefix.toString() + directory);
        prefix.append(directory.getName());
    }

    public void add(Directory child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", getName(), getSize());
    }
}
