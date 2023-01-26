package example._08_abstract_factory.listfactory;

import example._08_abstract_factory.factory.Item;
import example._08_abstract_factory.factory.Page;

class ListPage extends Page {

    private final StringBuilder sb = new StringBuilder();

    public ListPage(String title, String author) {
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
                <html><head><title>""").append(title).append("</title></head>\n");
        sb.append("""
                <body>
                <h1>""").append(title).append("</h1>\n");
    }

    private void appendContents() {
        sb.append("<ul>\n");
        for (Item content : getContents()) {
            sb.append(content.makeHTML());
        }
        sb.append("</ul>\n");
    }

    private void appendAuthor() {
        sb.append("<hr><address>").append(author).append("</address>\n");
        sb.append("</body></html>");
    }
}
