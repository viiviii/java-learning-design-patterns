package example._11_composite;

class Directory {
    private final String name;

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
        System.out.println(String.format("/%s (%d)", getName(), getSize()));
    }
}
