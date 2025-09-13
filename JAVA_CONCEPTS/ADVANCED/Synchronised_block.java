
class Printer {
    void printMessage(String message) {
        synchronized (this) {  // synchronized block
            for (int i = 1; i <= 3; i++) {
                System.out.println(message + " - " + i);
                try { Thread.sleep(500); } catch (Exception e) {}
            }
        }
    }
}

class MyyThread extends Thread {
    Printer p;
    String msg;
    MyyThread(Printer p, String msg) {
        this.p = p; this.msg = msg;
    }
    public void run() {
        p.printMessage(msg);
    }
}

public class Synchronised_block {
    public static void main(String[] args) {
        Printer printer = new Printer(); // shared object
        MyyThread t1 = new MyyThread(printer, "Hello");
        MyyThread t2 = new MyyThread(printer, "World");

        t1.start();
        t2.start();
    }
}

