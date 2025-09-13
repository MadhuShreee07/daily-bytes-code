
class Parent {
    static String Name = "madhu";  //static in field

    static void FamilyName() {
        System.out.println("heyyy");    //static in method
    }
}



public class Static_Keyword {
    public static void main(String[] args) {
        // Access through class name
        Parent.FamilyName(); 
       
       System.out.println(Parent.Name);
    }
}

//without creating the object we can directly call the method