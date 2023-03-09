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
        String prefix = "";

        prefix += "/";
        System.out.println(prefix + this);
        prefix += this.getName();

        for (Directory child : children) {
            prefix += "/";
            System.out.println(prefix + child);
            prefix += child.getName();
        }
    }

    public void add(Directory child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", getName(), getSize());
    }
}
