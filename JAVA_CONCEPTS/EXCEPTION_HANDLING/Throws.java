
class InvalidAgeException extends Exception {
        InvalidAgeException(String message) {
                super(message);

     }
}

class Throws {
        public static void main(String[] args) {
               int age = 15; // Test age
                   try {
                 // Throwing user-defined exception if age < 18
         if (age < 18) {
               throw new InvalidAgeException("Age must be 18 or above.");
         } else {
               System.out.println("You are eligible to vote.");
     }
}
              catch (InvalidAgeException e) {

                  System.out.println("Exception caught: " + e.getMessage());
}
                System.out.println("Program ended.");
     }
}

//this is used to create user defined exceptions