package example._09_bridge;

class Main {
    public static void main(String[] args) {
        Display d1; // 인자: "Hello, Korea."
        Display d2; // 인자: "Hello, World."
        CountDisplay d3; // 인자: "Hello, Universe."

        d1.display();
        d2.display();
        d3.display();

        d3.multiDisplay(5);
    }
}
