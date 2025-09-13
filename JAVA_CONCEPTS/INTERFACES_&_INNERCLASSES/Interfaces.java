


interface fatherr{
	abstract void call();
	abstract void talk();
}

class sonnn implements fatherr{ 
	public void talk() {
		System.out.println("talking");
	}
	public void call() {
		System.out.println("calling");
	}
}


public class Interfaces {
	public static void main(String args[]) {
		 sonnn s1=new sonnn();
	     s1.talk();
	     s1.call();
	}
}

//All methods in interface must be abstract
//for interface use implements