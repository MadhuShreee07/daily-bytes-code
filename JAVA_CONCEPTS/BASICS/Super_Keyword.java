
class Building {
    String type = "Generic Building";

    // Parent constructor
    Building() {
        System.out.println("Building constructor called");
    }

    void describe() {
        System.out.println("This is a " + type);
    }
}

class House extends Building {
    String type = "House";

    // Child constructor
    House() {
        super(); // Calls parent constructor
        System.out.println("House constructor called");
    }

    void showType() {
        System.out.println("Child type: " + type);
        System.out.println("Parent type: " + super.type); // Access parent field
    }

    @Override
    void describe() {
        System.out.println("House description");
        super.describe(); // Call parent method
    }
}

public class Super_Keyword {
    public static void main(String[] args) {
        House myHouse = new House();

        myHouse.showType();   // Access both parent and child 'type'
        myHouse.describe();   // Call overridden method + parent method
    }
}
