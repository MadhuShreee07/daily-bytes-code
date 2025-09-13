

abstract class computer{        //we cant create object for abstract classes
	void turnon() {
		System.out.println("turning on");
	}
	
	abstract void turnoff();   //we must override this abstract method
}

class HP extends computer{
	void turnoff() {
		System.out.println("HP is turning off");
	}
}

class DELL extends computer{
	void turnon() {
		System.out.println("dell is turing on");
	}
	
	void turnoff() {
		System.out.println("dell is turing off");
	}
}

public class Abstract_classes {
       public static void main(String args[]) {
    	   HP obj=new HP();
    	   obj.turnon();
    	   obj.turnoff();
    	   
    	   DELL obj1=new  DELL();
    	   obj1.turnon();
    	   obj1.turnoff();
       }
       
        
}
//we cant directly use abstract class
//we need to inherit then use it