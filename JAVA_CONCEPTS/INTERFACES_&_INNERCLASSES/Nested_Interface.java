
// Outer interface
interface OuterInterface {
    void outerMethod();

    // Nested Inner interface
    interface InnerInterface {
        void innerMethod();
    }
}

// Class implementing outer interface
class OnlyOuter implements OuterInterface {
    public void outerMethod() {
        System.out.println("This is OuterInterface method");
    }
}

// Class implementing inner interface
class OnlyInner implements OuterInterface.InnerInterface {
    public void innerMethod() {
        System.out.println("This is InnerInterface method");
    }
}

// Main class
public class Nested_Interface {
    public static void main(String[] args) {
        OnlyOuter obj1 = new OnlyOuter();
        OnlyInner obj2 = new OnlyInner();

        obj1.outerMethod();   // Calls outer interface method
        obj2.innerMethod();   // Calls inner interface method
    }
}

