package example._12_decorator;

class Display {
    private final String s;

    public Display(String s) {
        this.s = s;
    }

    public void show() {
        System.out.println(s);
    }
}
