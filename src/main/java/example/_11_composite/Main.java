package example._11_composite;

class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");

        root.add(bin);
        bin.add(new File("v1", 10000));
        bin.add(new File("latex", 20000));

        root.add(tmp);

        root.printList();
    }
}
