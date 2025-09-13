
public class Finally {
    public static void main(String[] args) {
    	
        try {
            int a = 10;
            int b = 0;
            int result = a / b;  // ❌ This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        } finally {
            // Always executed
            System.out.println("Finally block executed");
        }

    }
}
//finally block executes even if shows error or not