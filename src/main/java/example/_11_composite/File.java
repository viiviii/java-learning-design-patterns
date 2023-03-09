package example._11_composite;

class File extends Entry {

    public File(String name, int size) {
        super(name, size);
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
