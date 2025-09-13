

class Test {
    public <T> void showItemDetails(T item) {
        System.out.println("Value: " + item);
        System.out.println("Type: " + item.getClass().getName());
    }
}

public class Generic_Method {
    public static void main(String[] args) {
        Test t = new Test();
        t.showItemDetails("Hello");
        t.showItemDetails(100);
    }
}
