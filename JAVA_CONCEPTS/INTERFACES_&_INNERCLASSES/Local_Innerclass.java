


class OuterClass {

            void displayMessage() {
// Method-local inner class
              class InnerClass {
            	  
                     void print() {
                  System.out.println("Heyyy!!");
         }
}
              // Create an object of the inner class

            InnerClass inner = new InnerClass();
            inner.print();
      }
}

class Local_Innerclass {
       public static void main(String[] args) {

            OuterClass outer = new OuterClass();
            // Call the method containing the inner class
           outer.displayMessage(); 
       }
}


//Method Local Inner Classes or Local Inner Classes
//Inner class can be declared within a method of an outer class