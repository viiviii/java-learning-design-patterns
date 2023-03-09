package example._12_decorator;

import java.util.ArrayList;
import java.util.List;

public class FullBorder extends Display {
    private final Display display;

    public FullBorder(Display display) {
        this.display = display;
    }

    @Override
    protected List<String> getLines() {
        final var lines = new ArrayList<String>();

        lines.add(openAndCloseLine());
        for (String line : display.getLines()) {
            lines.add("|" + line + "|");
        }
        lines.add(openAndCloseLine());

        return lines;
    }

    private String openAndCloseLine() {
        return "+" + "-".repeat(display.getLines().get(0).length()) + "+"; // TODO
    }
}
