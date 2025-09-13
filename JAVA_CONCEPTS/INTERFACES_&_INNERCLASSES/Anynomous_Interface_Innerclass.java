

interface Greeting {
	    void sayHello();
	}

class Anynomous_Interface_Innerclass {
	    public static void main(String[] args) {
	        // Anonymous inner class implementing interface
	        Greeting greet = new Greeting() {
	            public void sayHello() {
	                System.out.println("Hello from Anonymous Inner Class (Interface)");
	            }
	        };

	        greet.sayHello();
	    }
	}



