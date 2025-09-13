

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable thread: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Runnable interrupted");
            }
        }
    }
}

class Thread_Runnable_Interface {
    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        Thread t1 = new Thread(r); // wrap Runnable inside Thread
        t1.start();

        // Main thread work
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread: " + i);
        }
    }
}
