package example._12_decorator;

import java.util.List;

abstract class Display {

    public void show() {
        for (var line : getLines()) {
            System.out.println(line);
        }
    }

    protected abstract List<String> getLines();
}
