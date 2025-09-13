class Animal{
	int noofLegs=4;
	
	public void eat() {
		System.out.println("i am eating");
	}
	
	public void walk() {
		System.out.println("i am walking");
	}
}

class dog extends Animal{
	boolean canbark=true;    //Even if we dont create eat and walk methods it inherits from animal class
	int noofLegs=5;
	
	public void eat() {
		System.out.println("dog is eating");
	}
	
	public void walk() {
		System.out.println("Dog is eating");
	}
}
public class Method_overriding {
       public static void main(String args[]) {
    	   Animal obj=new Animal();
    	   System.out.println(obj.noofLegs);
    	   obj.eat();
    	   obj.walk();
    	   
    	   dog obj1=new dog();
    	   System.out.println(obj1.noofLegs);     //it prints whats there in the sub class and not in super class
    	   System.out.println(obj1.canbark);
    	   obj.eat();
    	   obj.walk();
    	 
       }
}

