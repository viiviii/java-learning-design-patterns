package example._12_decorator;

import java.util.List;

class StringDisplay extends Display {
    private final String s;

    public StringDisplay(String s) {
        this.s = s;
    }

    @Override
    protected List<String> getLines() {
        return List.of(s);
    }
}
