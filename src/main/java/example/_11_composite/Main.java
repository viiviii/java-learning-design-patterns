package example._11_composite;

class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");

        root.add(bin);

        root.printList();
    }
}
