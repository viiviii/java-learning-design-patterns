package example._11_composite;

class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        File v1 = new File("v1", 10000);

        root.add(bin);
        bin.add(v1);

        root.printList();
    }
}
