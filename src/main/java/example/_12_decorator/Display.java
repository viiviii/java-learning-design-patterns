package example._12_decorator;

abstract class Display {

    public void show() {
        System.out.println(getMessage());
    }

    protected abstract String getMessage();
}
