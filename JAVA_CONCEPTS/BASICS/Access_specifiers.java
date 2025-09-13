class Personnn {
    
    private String no = "123-45-6789";      // private field
    protected int age = 25;                  // protected field
    public String country = "India";         // public field

    
    private void showno() {                 // private method(Accessible only in this method)
        System.out.println("SSN: " + no);
    }


    protected void showAge() {               // protected method(Accessible in package)
        System.out.println("Age: " + age);
    }

    public void showCountry() {              // public method
        System.out.println("Country: " + country);
    }

    // Public helper to safely call private method
    public void showPrivateMethod() {
        showno(); // private accessible only inside Person
    }
}

class Student extends Personnn {
    public void displayAll() {
        
        System.out.println("Accessing in subclass:");
        // System.out.println("SSN: " + no); ❌ private not accessible
        System.out.println("Age: " + age);         // protected OK
        System.out.println("Country: " + country); // public OK

        // Access methods
       // showno(); ❌ private not accessible
        showAge();        // protected OK
        showCountry();    // public OK
    }
}

public class Access_specifiers {
    public static void main(String[] args) {
        Personnn p = new Personnn();
        Student s = new Student();

        System.out.println("=== Access from Main (non-subclass) ===");

        // Fields
        // System.out.println(p.no); ❌ private not accessible
        System.out.println("Age: " + p.age);          // protected (same package)
        System.out.println("Country: " + p.country);  // public

        // Methods
        // p.showSSN(); ❌ private not accessible
        p.showAge();         // protected (same package)
        p.showCountry();     // public
        p.showPrivateMethod(); // ✅ indirect access to private

        System.out.println("\n=== Access from Subclass ===");
        s.displayAll();
    }
}
