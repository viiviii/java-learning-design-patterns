package example._07_builder;

class TextBuilder extends Builder {

    private static final String OPENING_CLOSING_LINE = "==============================";

    public TextBuilder() {
        appendWithNewLine(OPENING_CLOSING_LINE);
    }

    @Override
    public Builder makeTitle(String title) {
        append("[").append(title).appendWithNewLine("]");
        appendNewLine();
        return this;

    }

    @Override
    public Builder makeString(String str) {
        append("■").appendWithNewLine(str);
        appendNewLine();
        return this;
    }

    @Override
    public Builder makeItems(String... items) {
        for (String item : items) {
            append("- ").appendWithNewLine(item);
        }
        appendNewLine();
        return this;
    }

    @Override
    public void close() {
        appendWithNewLine(OPENING_CLOSING_LINE);
    }

    public String getTextResult() {
        return getResult();
    }
}
