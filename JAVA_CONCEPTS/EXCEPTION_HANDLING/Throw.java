

class Throw {
    public static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Not eligible to vote"); // using throw
        } else {
            System.out.println("Eligible to vote");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(16); // ❌ will throw exception
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}

//throw helps to show the exception msg