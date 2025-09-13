

interface MyGenericInterface<T> {
    void display(T value);
}

class StringPrinter implements MyGenericInterface<String> {
    public void display(String value) { System.out.println(value); }
}

public class Generic_Interface {
    public static void main(String[] args) {
        MyGenericInterface<String> printer = new StringPrinter();
        printer.display("Generics in Java");
    }
}

