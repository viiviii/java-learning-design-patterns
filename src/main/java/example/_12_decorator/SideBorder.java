package example._12_decorator;

public class SideBorder extends Display {
    private final Display display;
    private final char border;

    public SideBorder(Display display, char border) {
        this.display = display;
        this.border = border;
    }

    @Override
    protected String getMessage() {
        return border + display.getMessage() + border;
    }
}
