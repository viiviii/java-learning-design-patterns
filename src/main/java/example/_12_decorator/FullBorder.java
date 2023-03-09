package example._12_decorator;

public class FullBorder extends Display {
    private final Display display;

    public FullBorder(Display display) {
        this.display = display;
    }

    @Override
    public void show() {
        showLine();
        super.show();
        showLine();
    }

    private void showLine() {
        var line = "+" + "-".repeat(display.getMessage().length()) + "+";
        System.out.println(line);
    }

    @Override
    protected String getMessage() {
        return "|" + display.getMessage() + "|";
    }
}
