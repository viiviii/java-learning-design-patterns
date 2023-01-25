package example._07_builder;

class HTMLBuilder extends Builder {

    public HTMLBuilder() {
        appendWithNewLine("<!DOCTYPE html>");
        appendWithNewLine("<html>");
    }

    @Override
    public Builder makeTitle(String title) {
        append("<head><title>").append(title).appendWithNewLine("</title></head>");
        append("<body>").appendNewLine();
        append("<h1>").append(title).appendWithNewLine("</h1>");
        appendNewLine();
        return this;
    }

    @Override
    public Builder makeString(String str) {
        append("<p>").append(str).appendWithNewLine("</p>");
        appendNewLine();
        return this;
    }

    @Override
    public Builder makeItems(String... items) {
        appendWithNewLine("<ul>");
        for (String item : items) {
            append("<li>").append(item).appendWithNewLine("</li>");
        }
        appendWithNewLine("</ul>");
        appendNewLine();
        return this;
    }

    @Override
    public void close() {
        appendWithNewLine("</body></html>");
    }

    public String getHTMLResult() {
        return getResult();
    }
}
