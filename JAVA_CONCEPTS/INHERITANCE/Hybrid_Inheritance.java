

//COMBINING 2 INHERITANCE

class Person {
    void displayPerson() {
        System.out.println("I am a Person");
    }
}

class Father extends Person {
    void displayFather() {
        System.out.println("I am the Father");
    }
}

class mom extends Person {
    void displayMother() {
        System.out.println("I am the Mother");
    }
}

// Child extends Father (Multilevel path continues)
class Child extends Father {
    void displayChild() {
        System.out.println("I am the Child");
    }
}

public class Hybrid_Inheritance {
    public static void main(String[] args) {
        Child c = new Child();
        
        c.displayPerson(); // from Person
        c.displayFather(); // from Father
        c.displayChild();  // from Child
        
        
        mom m = new mom();
        m.displayPerson();
        m.displayMother();
    }
}

