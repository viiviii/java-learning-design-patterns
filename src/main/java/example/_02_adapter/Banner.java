package example._02_adapter;

class Banner {
    private final String str;

    public Banner(String str) {
        this.str = str;
    }

    public void showWithParen() {
        show("(", ")");
    }

    public void showWithAster() {
        show("*", "*");
    }

    private void show(String open, String close) {
        System.out.printf("%s%s%s", open, str, close);
    }
}
