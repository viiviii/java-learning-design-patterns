package example._08_abstract_factory.divfactory;

import example._08_abstract_factory.factory.Item;
import example._08_abstract_factory.factory.Page;

class DivPage extends Page {

    private final StringBuilder sb = new StringBuilder();

    public DivPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        appendTitle();
        appendContents();
        appendAuthor();
        
        return sb.toString();
    }

    private void appendTitle() {
        sb.append("""
                <!DOCTYPE html>
                <html><head><title>""").append(title).append("</title><style>\n");
        sb.append("""
                div.TRAY { padding:0.5em; margin-left:5em; border:1px solid black; }
                div.LINK { padding:0.5em; background-color: lightgray; }
                </style></head><body>
                <h1>""").append(title).append("</h1>\n");
    }

    private void appendContents() {
        for (Item item : getContents()) {
            sb.append(item.makeHTML());
        }
    }

    private void appendAuthor() {
        sb.append("<hr><address>").append(author).append("</address>\n");
        sb.append("</body></html>");
    }
}
