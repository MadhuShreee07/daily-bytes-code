


public class Garbage_Collection {
 // Finalize method to be called before GC destroys the object
        public void finalize() {
             System.out.println("Garbage Collected for object: ");
}
        
public static void main(String[] args) {
	
	Garbage_Collection obj1 = new Garbage_Collection();
	Garbage_Collection obj2 = new Garbage_Collection();
	
         // Nullifying references
             obj1 = null;
              obj2 = null;

         // Requesting JVM to run Garbage Collector
                     System.gc();
               System.out.println("End of main method");
}

}
