package example._12_decorator;

import java.util.ArrayList;
import java.util.List;

public class SideBorder extends Display {
    private final Display display;
    private final char border;

    public SideBorder(Display display, char border) {
        this.display = display;
        this.border = border;
    }

    @Override
    protected List<String> getLines() {
        final var lines = new ArrayList<String>();

        for (String line : display.getLines()) {
            lines.add(border + line + border);
        }

        return lines;
    }
}
