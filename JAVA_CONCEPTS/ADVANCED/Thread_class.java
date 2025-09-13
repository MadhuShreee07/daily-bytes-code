
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread running: " + i);
            try {
                Thread.sleep(500); // pause for 0.5s
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class Thread_class {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // starts a new thread

        // Main thread continues
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main running: " + i);
        }
    }
}

/*Key Thread Methods (Quick List)
start() → begins execution, moves to Runnable state
run() → actual task code
sleep(ms) → pause thread temporarily
join() → wait for another thread to finish
interrupt() → signals a thread to stop
isAlive() → check if thread is still running
setName(), getName() → set/get thread name
setPriority(), getPriority() → manage prioritie*/