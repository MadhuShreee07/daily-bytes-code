

/*EXCEPTION - Run time error which will occur during program execution

Types of Exceptions

Checked Exceptions – Must be handled with try-catch or declared with throws.(compile time exception)
Example: IOException, SQLException.

Unchecked Exceptions – Occur at runtime; usually caused by programming mistakes.
Example: ArithmeticException, NullPointerException. */

public class Try_Catch {
	public static void main(String[] args) {
		
	        try {
	            int result = 10 / 0;  
	            System.out.println("Result: " + result);
	            
	        } catch (ArithmeticException e) {
	            System.out.println("Cannot divide by zero!");
	            
	        } 
	    }
	}

	
	
