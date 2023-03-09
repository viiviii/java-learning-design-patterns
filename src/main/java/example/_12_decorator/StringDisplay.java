package example._12_decorator;

class StringDisplay extends Display {
    private final String s;

    public StringDisplay(String s) {
        this.s = s;
    }

    @Override
    protected String getMessage() {
        return s;
    }
}
