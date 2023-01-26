package example._08_abstract_factory.divfactory;

import example._08_abstract_factory.factory.Item;
import example._08_abstract_factory.factory.Tray;

class DivTray extends Tray {

    protected DivTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        final var INDENT = "  ";
        final var sb = new StringBuilder();
        
        sb.append(String.format("<p><b>%s</b></p>%n", caption));
        sb.append("<div class=\"TRAY\">\n");
        for (Item item : this) {
            sb.append(INDENT).append(item.makeHTML());
        }
        sb.append("</div>\n");

        return sb.toString();
    }
}
