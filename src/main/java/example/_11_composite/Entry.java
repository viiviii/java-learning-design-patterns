package example._11_composite;

abstract class Entry {
    private final String name;
    private final int size;

    protected Entry(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public final void printList() {
        final var prefix = new StringBuilder();
        printList(prefix);
    }

    protected abstract void printList(StringBuilder prefix);

    @Override
    public String toString() {
        return String.format("%s (%d)", getName(), getSize());
    }
}
