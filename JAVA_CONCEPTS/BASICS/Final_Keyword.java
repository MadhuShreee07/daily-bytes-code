

class Parentt {
    
    final String country = "USA";

    final void showCountry() {
        System.out.println("Country: " + country);
    }

           void greet() {
        System.out.println("Hello from Parent!");
    }
}

class Childd extends Parentt {
   
    // overriding non-final method
    void greet() {
        System.out.println("Hello from Child!");
    }
}

public class Final_Keyword {
    public static void main(String[] args) {
        Childd c = new Childd();

        System.out.println("Final Field (Country): " + c.country);

        c.showCountry();
        c.greet();
    }
}

//final field (can’t be changed once assigned)
//final method (can’t be overridden in child class)