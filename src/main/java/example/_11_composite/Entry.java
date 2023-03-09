package example._11_composite;

abstract class Entry {

    public final void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    public abstract String getName();

    public abstract int getSize();

    @Override
    public String toString() {
        return String.format("%s (%d)", getName(), getSize());
    }
}
