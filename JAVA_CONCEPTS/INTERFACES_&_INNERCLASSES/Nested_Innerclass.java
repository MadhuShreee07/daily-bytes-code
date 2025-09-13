
class OuterrClass {
    int x = 10;

    class MiddleClass {
        int y = 5;

        class InnerClass {
            int z = 1;
        }
    }
}

public class Nested_Innerclass {
    public static void main(String[] args) {
        OuterrClass Out1 = new OuterrClass();

        OuterrClass.MiddleClass Mid1 = Out1.new MiddleClass();

        OuterrClass.MiddleClass.InnerClass In1 = Mid1.new InnerClass();

        System.out.println(In1.z + Mid1.y + Out1.x); // Outputs 16
    }
}


//In Java, it is also possible to nest classes (a class within a class).