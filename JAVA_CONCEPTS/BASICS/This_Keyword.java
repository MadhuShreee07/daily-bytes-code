

class Vehicle {
    int wheels;
    String brand;

    Vehicle(int wheels, String brand) {
        // 'this' differentiates between instance variable and parameter
        this.wheels = wheels;
        this.brand = brand;
    }
    
    public void displayy() {
    	System.out.println(wheels);
    	System.out.println(brand);
    }
}


public class This_Keyword{
    public static void main(String[] args) {
        Vehicle myCar = new Vehicle(4, "Tesla");
        myCar.displayy();
    }
}
