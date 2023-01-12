package example._03_template_method;

class Main {
    public static void main(String[] args) {
        // 'H'를 가진 CharDisplay 인스턴스를 하나 만든다
        AbstractDisplay d1 = new CharDisplay('H');

        // "Hello, world."를 가진 StringDisplay 인스턴스를 하나 만든다
        AbstractDisplay d2 = new StringDisplay("Hello, world.");

        // 실제 동작은 CharDisplay, StringDisplay 클래스에서 정해진다
        d1.display();
        d2.display();
    }
}
