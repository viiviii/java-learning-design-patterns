package example._02_adapter;

class PrintBanner extends Banner implements Print {
    public PrintBanner(String str) {
        super(str);
    }

    @Override
    public void printWeak() {
        super.showWithParen();
    }

    @Override
    public void printStrong() {
        super.showWithAster();
    }
}
